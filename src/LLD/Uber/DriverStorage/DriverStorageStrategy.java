package LLD.Uber.DriverStorage;

import LLD.Uber.Driver;

import java.util.List;
import java.util.Map;

public interface DriverStorageStrategy {
    //This is used so that we can store driver details according to our strategy.
    //For interview we will use inmemory storage , but in production we will be using geoSpatialDatabases.
    void addDriver(Driver driver);
    Map<String,Driver> getDrivers();
    void removeDriver(Driver driver);
}
