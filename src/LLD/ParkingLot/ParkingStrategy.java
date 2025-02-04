package LLD.ParkingLot;

import java.util.List;

public interface ParkingStrategy {
    ParkingSpot getAvailableSpot(List<Floor> floors);
}
