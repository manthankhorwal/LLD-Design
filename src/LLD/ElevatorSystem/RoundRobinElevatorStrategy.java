package LLD.ElevatorSystem;

import java.util.List;

public class RoundRobinElevatorStrategy implements SchedulingStrategy{
   public int lastAssigned = -1;
    @Override
    public Elevator assignElevator(int destination, List<Elevator> elevators) {
            lastAssigned = (lastAssigned + 1) % elevators.size();
             for(Elevator elevator:elevators){
                 if(lastAssigned==elevator.getId())
                     return elevator;
            }
             return null;
        }
    }

