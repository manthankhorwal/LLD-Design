package LLD.VendingMachine;

public class OutOfStockState implements State{
    @Override
    public void handle(VendingMachine machine) {
        System.out.println("Item out of stack , Please try again later");
        machine.setState(new IdleState());
        machine.getState().handle(machine);
    }
}
