package LLD.Uber;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TraversalDriverFind implements DriverMatchingStrategy {
    @Override
    public List<Driver> findDrivers(Location passengerLocation, Map<String, Driver> drivers) {
        return drivers.values().stream()
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
