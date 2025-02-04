package LLD.ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class Floor {
   private int floorNumber;
   private List<ParkingSpot> spots;

    public Floor(int floorNumber, int spotsPerFloor) {
        this.floorNumber = floorNumber;
        this.spots = new ArrayList<>();
        for(int i=1;i<=spotsPerFloor;i++)
            spots.add(new ParkingSpot(i));
    }

    public List<ParkingSpot> getSpots() {
        return spots;
    }

    public int getFloorNumber() {
        return floorNumber;
    }
}
