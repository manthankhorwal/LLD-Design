package LLD.VendingMachine;

public class DispenseItemState implements State{
    @Override
    public void handle(VendingMachine machine) {
        int itemPrice =machine.getInventory().getItem(machine.selectedItemCode).getPrice();
      if(machine.getBalance() >= itemPrice){
          System.out.println("Dispensing Product");
        machine.setBalance(machine.getBalance()-itemPrice);
      }
    }
}
