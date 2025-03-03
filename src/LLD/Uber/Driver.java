package LLD.Uber;

public class Driver {
    private int id;
    private String name;
    private String contact;
    private String licensePlate;
    private Location location;
    private DriverStatus status;

    public Driver(int id, String name, String contact, String licensePlate, Location location, DriverStatus status) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.licensePlate = licensePlate;
        this.location = location;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setStatus(DriverStatus status) { this.status = status; }
    public DriverStatus getStatus() { return status; }
    public Location getLocation() { return location; }
    public String getName() { return name; }
    public String getContact() { return contact; }
}
