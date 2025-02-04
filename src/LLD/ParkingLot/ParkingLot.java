package LLD.ParkingLot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
   private List<Floor> floors;
    private static volatile ParkingLot  instance;
    ParkingStrategy parkingStrategy;
    Map<String,Ticket> activeTickets;

    private ParkingLot(int numberOfFloors, int spotsPerFloor) {
        this.floors = new ArrayList<>();
        for (int i = 1; i <= numberOfFloors; i++) {
            floors.add(new Floor(i, spotsPerFloor));
        }
        this.parkingStrategy = new FindClosestParkingStrategy();
        this.activeTickets = new HashMap<>();
    }
    public static ParkingLot getInstance(int floors,int spots){
        if(instance==null){
            synchronized (ParkingLot.class){
                if(instance==null){
                    instance = new ParkingLot(floors,spots);
                }
            }
        }
        return instance;
    }
    public void setParkingStrategy(ParkingStrategy strategy) {
        this.parkingStrategy = strategy;
    }
    public Ticket parkVehicle(Vehicle vehicle){
        ParkingSpot spot=parkingStrategy.getAvailableSpot(floors);
        if(!spot.isOccupied()){
          spot.park(vehicle);
          Ticket ticket=new Ticket(vehicle,findFloor(spot),spot.getSpotID());
          activeTickets.put(ticket.getTicketId(),ticket);
            System.out.println("Ticket issued" + ticket);
            return ticket;
        }
     return null;
    }
    public double removeVehicle(String ticketId) {
        Ticket ticket = activeTickets.get(ticketId);
        if (ticket == null) {
            System.out.println("❌ Invalid Ticket.");
            return -1;
        }
        for (Floor floor : floors) {
            for (ParkingSpot spot : floor.getSpots()) {
                if (spot.isOccupied() && spot.getSpotID() == ticket.getSpotId()) {
                    spot.vacate();
                    ticket.markExit();
                    double fee = ticket.calculateFee();
                    activeTickets.remove(ticketId);
                    System.out.println("✅ Vehicle Removed: " + ticket.getVehicle().getLicenseID() +
                            ", Fee: $" + fee);
                    return fee;
                }
            }
        }
        System.out.println("❌ Vehicle Not Found.");
        return -1;
    }
    private int findFloor(ParkingSpot spot) {
        for (Floor floor : floors) {
            if (floor.getSpots().contains(spot)) {
                return floor.getFloorNumber();
            }
        }
        return -1;
    }
}