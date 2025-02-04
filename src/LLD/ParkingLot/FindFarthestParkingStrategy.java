package LLD.ParkingLot;

import java.util.List;

public class FindFarthestParkingStrategy implements ParkingStrategy{

    @Override
    public ParkingSpot getAvailableSpot(List<Floor> floors) {
        ParkingSpot s=null;
        for (Floor floor : floors) {
            for (ParkingSpot spot : floor.getSpots()) {
                if (spot.isOccupied()) {
                    s= spot;
                }
            }
        }
        return s;
    }

}
