package LLD.Uber.DriverMatching;

import LLD.Uber.Driver;
import LLD.Uber.DriverStatus;
import LLD.Uber.DriverStorage.DriverStorageStrategy;
import LLD.Uber.Location;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TraversalDriverFind implements DriverMatchingStrategy {
    //This strategy is used to show a flow in interview , which will normally take an map , and find available drivers from it.
    //Here we will use InMemory storage , to get the map and find nearby drivers
    DriverStorageStrategy driverStorageStrategy;
    public TraversalDriverFind(DriverStorageStrategy driverStorageStrategy){
        this.driverStorageStrategy=driverStorageStrategy;
    }
    //By using this we dont need to pass a drivers list, you can see in previous commits that we are passing a driver list to get the available drivers.
    // but now this Driver finding traversal will use inMemory storage , and GepSpatial strategy will use remote database to get the list of drivers and find closest.

    @Override
    public List<Driver> findDrivers(Location passengerLocation) {

        return driverStorageStrategy.getDrivers().values().stream()
                .filter(driver -> driver.getStatus() == DriverStatus.AVAILABLE)
                .sorted((d1, d2) -> Double.compare(
                        calculateDistance(d1.getLocation(), passengerLocation),
                        calculateDistance(d2.getLocation(), passengerLocation)))
                .limit(5) // Limit to the 5 closest drivers
                .collect(Collectors.toList());
    }

    private double calculateDistance(Location loc1, Location loc2) {
        return Math.random() * 10; // Simulated distance
    }

}
