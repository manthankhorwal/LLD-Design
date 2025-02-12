package LLD.VendingMachine;

public class AcceptingMoneyState implements State{
    @Override
    public void handle(VendingMachine machine) {
         machine.setState(new DispenseItemState());
         machine.getState().handle(machine);
        }
    }

