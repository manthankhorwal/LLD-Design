package LLD.ParkingLot;

import java.util.List;

public class FindClosestParkingStrategy implements ParkingStrategy{

    @Override
    public ParkingSpot getAvailableSpot(List<Floor> floors) {
        for (Floor floor : floors) {
            for (ParkingSpot spot : floor.getSpots()) {
                if (!spot.isOccupied()) {
                    return spot;
                }
            }
        }
        return null;
    }
}
