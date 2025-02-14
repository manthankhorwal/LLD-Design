package LLD.ElevatorSystem;

import java.util.List;

public class ClosestElevatorStrategy implements SchedulingStrategy {
    @Override
    public Elevator assignElevator(int destination, List<Elevator> elevators) {
        Elevator closestElevator = null;
        int minDistance = Integer.MAX_VALUE;

        for (Elevator elevator : elevators) {
            int distance = Math.abs(elevator.getCurrentFloor() - destination);
            boolean isDirectionMatching =
                    (elevator.getState().equals(State.MOVING_UP) && destination >= elevator.getCurrentFloor()) ||
                            (elevator.getState().equals(State.MOVING_DOWN) && destination <= elevator.getCurrentFloor()) ||
                            elevator.getState().equals(State.IDLE);
            if (isDirectionMatching && distance < minDistance) {
                minDistance = distance;
                closestElevator = elevator;
            }
        }
        return closestElevator;
    }
}
