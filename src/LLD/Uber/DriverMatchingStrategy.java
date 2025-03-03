package LLD.Uber;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorCompletionService;

public interface DriverMatchingStrategy {
 List<Driver> findDrivers(Location passengerLocation , Map<String,Driver> drivers);
}
