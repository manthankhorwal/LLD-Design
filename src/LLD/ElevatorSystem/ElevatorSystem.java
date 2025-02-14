package LLD.ElevatorSystem;

import java.util.ArrayList;
import java.util.List;

public class ElevatorSystem {
    private static volatile ElevatorSystem instance;
    private List<Elevator> elevators;
    private SchedulingStrategy scheduler;
    private ElevatorSystem(int numOfElevators,SchedulingStrategy scheduler){
       elevators=new ArrayList<>();
        for(int i=0;i<numOfElevators;i++){
            elevators.add(new Elevator(i));
        }
        this.scheduler=scheduler;
    }
    public static ElevatorSystem  getInstance(int numberOfElevators, SchedulingStrategy initialStrategy) {
        if (instance == null) {
            synchronized (ElevatorSystem.class) {
                if (instance == null) {
                    instance = new ElevatorSystem(numberOfElevators, initialStrategy);
                }
            }
        }
        return instance;
    }
    public void setSchedulingStrategy(SchedulingStrategy strategy){
        this.scheduler=strategy;
    }
    public void handleOuterRequest(int destinationFloor){
        Elevator assignedElevator=scheduler.assignElevator(destinationFloor,elevators);
        Direction direction=Direction.DOWN;
        if(destinationFloor-assignedElevator.getCurrentFloor()>0){
            direction=Direction.UP;
        }
        assignedElevator.addRequest(destinationFloor,direction);
    }
    public void handleInnerRequest(int elevatorId,int destinationFloor){
        Elevator assignedElevator=elevators.get(elevatorId);
        Direction direction=Direction.DOWN;
        if(destinationFloor-assignedElevator.getCurrentFloor()>0){
            direction=Direction.UP;
        }
        assignedElevator.addRequest(destinationFloor,direction);
    }
    public void processAllElevators() {
        for (Elevator elevator : elevators) {
            elevator.processRequests();
         }
    }
}
