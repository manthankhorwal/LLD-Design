package LLD.ElevatorSystem;

public class Client {
    public static void main(String[] args) {
   ElevatorSystem elevatorSystem=ElevatorSystem.getInstance(10,new ClosestElevatorStrategy());
   elevatorSystem.handleOuterRequest(5);
   elevatorSystem.processAllElevators();
        elevatorSystem.handleOuterRequest(2);
        elevatorSystem.processAllElevators();
    }
}
