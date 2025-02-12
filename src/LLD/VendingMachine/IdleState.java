package LLD.VendingMachine;

public class IdleState implements State{
    @Override
    public void handle(VendingMachine machine) {
        System.out.println("Welcome. Please select item");
    }
}
