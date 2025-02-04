package LLD.ParkingLot;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

class Ticket {
    private String ticketId;
    private Vehicle vehicle;
    private int floorNumber;
    private int spotId;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private static final double HOURLY_RATE = 10.0; // Example rate

    public Ticket(Vehicle vehicle, int floorNumber, int spotId) {
        this.ticketId = UUID.randomUUID().toString();
        this.vehicle = vehicle;
        this.floorNumber = floorNumber;
        this.spotId = spotId;
        this.entryTime = LocalDateTime.now();
    }

    public void markExit() {
        this.exitTime = LocalDateTime.now();
    }

    public double calculateFee() {
        if (exitTime == null) {
            throw new IllegalStateException("Exit time is not recorded yet.");
        }
        long hours = Duration.between(entryTime, exitTime).toHours();
        return (hours == 0) ? HOURLY_RATE : hours * HOURLY_RATE;
    }

    public String getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public int getSpotId() {
        return spotId;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId='" + ticketId + '\'' +
                ", vehicle=" + vehicle.getLicenseID() +
                ", floor=" + floorNumber +
                ", spot=" + spotId +
                ", entryTime=" + entryTime +
                ", exitTime=" + exitTime +
                '}';
    }
}

