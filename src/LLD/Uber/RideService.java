package LLD.Uber;

import java.util.*;
import java.util.concurrent.*;

public class RideService {
    private static volatile RideService instance=null;
    private final Map<String,Passenger> passengers;
    private final Map<String,Driver> drivers;
    private final Map<String,Ride> rides;
    private final Queue<Ride> requestedRides;
    private final ExecutorService notificationService;
    private final ExecutorService rideMatchingService;
    private  DriverMatchingStrategy findDrivers;
    private final ExecutorService driverRequestService;
    private  IdGenerationStrategy getGeneratedId;
    private DriverStorageStrategy driverStorageStrategy;
    private RideService(){
        passengers=new ConcurrentHashMap<>();
        drivers = new ConcurrentHashMap<>();
        rides = new ConcurrentHashMap<>();
        requestedRides = new ConcurrentLinkedQueue<>();
        notificationService = Executors.newFixedThreadPool(5);
        rideMatchingService = Executors.newFixedThreadPool(3);
        findDrivers=new TraversalDriverFind();
        driverRequestService=Executors.newFixedThreadPool(3);
        getGeneratedId=new UUIDGeneration();
        driverStorageStrategy=new InMemoryDriverStorage();
    }
    public static RideService getInstance(){
        if(instance==null){
            synchronized (RideService.class){
               if(instance==null){
                   instance=new RideService();
               }
            }
        }
        return instance;
    }
    public void addPassenger(Passenger passenger){ //Register passenger
        passengers.putIfAbsent(passenger.getContact(),passenger);
    }
    public void addDriver(Driver driver) { //Register drivers
        drivers.putIfAbsent(driver.getContact(), driver);
    }

    public void requestRide(Passenger passenger, Location source , Location destination){
        Ride ride=new Ride(getGeneratedId.provideID(), passenger,null,source,destination,RideStatus.REQUESTED,0.0);
        requestedRides.offer(ride);// in big system , it will be done using a messaging queue kafka
        while(!requestedRides.isEmpty()) {
            rideMatchingService.submit(() -> matchRide(requestedRides.poll())); // So multiple rides will be requested by different threads
        }

    }
    private void matchRide(Ride ride){
        List<Driver> availableDrivers = findDrivers.findDrivers(ride.getSource(),drivers); // as multiple threads are calling this function , findNearest will be called by multiple threads
        // and it could happen that same driver can be in result for multiple rides , because this driver is closer to multiple rides
        if (availableDrivers.isEmpty()) {
            System.out.println("❌ No available drivers found for ride: " + ride.getId());
            return;
        }
        List<Callable<Driver>> driverTasks=new ArrayList<>(); // here as written above , same driver can get request for multiple rides
        for(int i=0;i<availableDrivers.size();i++){
            int finalI = i;
            Callable<Driver> task=()->requestDriverAcceptance(availableDrivers.get(finalI),ride);
        }
       try{
           Driver acceptedDriver= driverRequestService.invokeAny(driverTasks);  //So here can be case when driver accepted both rides , so in this sync is required on that driver object
           //so here multiple riders can have same acceptedDriver because he accepted multiple rides , so here sync is required so that only one ride can change it status and all other request declines.

           synchronized (acceptedDriver){
               if(acceptedDriver.getStatus()==DriverStatus.AVAILABLE){
                   acceptRide(acceptedDriver,ride);
               }
           }
       }
       catch (Exception e){
           System.out.println("Ride Request Failed");
       }

    }
    private Driver requestDriverAcceptance(Driver driver, Ride ride) throws InterruptedException,ExecutionException {
        notifyDriver(driver);
        Thread.sleep(new Random().nextInt(2000) + 500); // Simulating driver response delay
        if(new Random().nextBoolean()) {  //50% chance of acceptance of ride
            System.out.println("🚖 Driver " + driver.getName() + " accepted ride: " + ride.getId());
            return driver;
        }else{
            System.out.println("❌ Driver " + driver.getName() + " rejected ride: " + ride.getId());
            throw new ExecutionException(new RuntimeException("Driver rejected ride"));
        }

    }

    private void notifyDriver(Driver driver) {
        notificationService.submit(()->System.out.println(driver.getName()+" We got a new Ride request for you"));
    }

    private void acceptRide(Driver bestDriver, Ride ride) {
        if(ride.getStatus()==RideStatus.REQUESTED){
            ride.setDriver(bestDriver);
            ride.setStatus(RideStatus.ACCEPTED);
            bestDriver.setStatus(DriverStatus.BUSY);
            rides.put(ride.getId(),ride);
            notifyPassenger(ride , "We found a ride for you");
        }
    }
    public void completeRide(Ride ride) {
        if (ride.getStatus() == RideStatus.IN_PROGRESS) {
            ride.setStatus(RideStatus.COMPLETED);
            ride.getDriver().setStatus(DriverStatus.AVAILABLE);
            notifyPassenger(ride,"Ride is completed");
        }
    }
    private void notifyPassenger(Ride ride, String message) {
        notificationService.submit(()-> System.out.println(ride.getPassenger().getName()+" "+message));
    }


}
