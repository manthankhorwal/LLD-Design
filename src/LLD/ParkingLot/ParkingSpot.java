package LLD.ParkingLot;

public class ParkingSpot {
   private int spotID;
   private boolean isOccupied;
   private Vehicle vehicle;
    public ParkingSpot(int spotID) {
        this.spotID = spotID;
        this.isOccupied=false;
        this.vehicle=null;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getSpotID() {
        return spotID;
    }
    public void park(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isOccupied = true;
    }
    public void vacate() {
        this.vehicle = null;
        this.isOccupied = false;
    }
    public boolean isOccupied() {
        return isOccupied;
    }

}
