package LLD.ParkingLot;

public class Client {
    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getInstance(3, 5);

        Vehicle car1 = new Vehicle("KA-01-HH-1234", VehicleType.CAR);
        Vehicle car2 = new Vehicle("KA-01-HH-9999", VehicleType.CAR);

        Ticket ticket1 = parkingLot.parkVehicle(car1);
        Ticket ticket2 = parkingLot.parkVehicle(car2);

        if (ticket1 != null) {
            parkingLot.removeVehicle(ticket1.getTicketId());
        }

        if (ticket2 != null) {
            parkingLot.removeVehicle(ticket2.getTicketId());
        }
    }
    }

