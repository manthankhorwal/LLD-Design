package LLD.ElevatorSystem;

import java.util.List;

public interface SchedulingStrategy {
    Elevator assignElevator(int destination, List<Elevator> elevators);
}
