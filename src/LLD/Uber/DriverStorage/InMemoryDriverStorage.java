package LLD.Uber.DriverStorage;

import LLD.Uber.Driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryDriverStorage implements DriverStorageStrategy {
    //This is created to mimic a database in interview , this will be used in TraversalDriverFind strategy , which will normally traverse this map and find nearest driver
   private ConcurrentHashMap<String, Driver> drivers=new ConcurrentHashMap<>();
    @Override
    public void addDriver(Driver driver) {
        drivers.putIfAbsent(driver.getContact(), driver);
    }

    @Override
    public Map<String, Driver> getDrivers() {
        return drivers;
    }



    @Override
    public void removeDriver(Driver driver) {
  drivers.remove(driver.getContact());
    }
}
