package LLD.ParkingLot;

public class Vehicle {
  private String licenseID;
   private VehicleType vehicleType;

    public Vehicle(String licenseID, VehicleType vehicleType) {
        this.licenseID = licenseID;
        this.vehicleType = vehicleType;
    }

    public String getLicenseID() {
        return licenseID;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
