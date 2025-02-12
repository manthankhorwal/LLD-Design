package LLD.VendingMachine;

import com.sun.source.tree.IfTree;

public class RefundState implements State{
    @Override
    public void handle(VendingMachine machine) {
        System.out.println("Refunding the remaining money");
       machine.setBalance(0);
       machine.setState(new IdleState());
       machine.getState().handle(machine);
    }
}
