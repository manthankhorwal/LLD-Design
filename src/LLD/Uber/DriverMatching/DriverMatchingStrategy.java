package LLD.Uber.DriverMatching;

import LLD.Uber.Driver;
import LLD.Uber.Location;

import java.util.List;
import java.util.Map;

public interface DriverMatchingStrategy {
 List<Driver> findDrivers(Location passengerLocation );
}
