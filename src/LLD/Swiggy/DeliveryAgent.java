package LLD.Swiggy;

import java.util.concurrent.locks.ReentrantLock;

public class DeliveryAgent {
    private final String id;
    private final String name;
    private final String phone;
    private Location location;
    private boolean available;


    public DeliveryAgent(String id, String name, String phone, Location location) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.location = location;
        this.available = true;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() { return location; }
    public boolean isAvailable() { return available; }
    public String getPhone() { return phone; }
    public String getName() { return name; }

}
