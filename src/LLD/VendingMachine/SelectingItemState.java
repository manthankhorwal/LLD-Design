package LLD.VendingMachine;

public class SelectingItemState implements State{
    @Override
    public void handle(VendingMachine machine) {
        int selectedItem = machine.getSelectedItemCode();
        if (!machine.getInventory().isCodeValid(selectedItem)) {
            System.out.println("Invalid Product Code");
            machine.setState(new IdleState());
            machine.getState().handle(machine);
        } else {
            Item item = machine.getInventory().getItem(selectedItem);
            System.out.println("Selected item name " + item.getName());

            if (item.getQuantity() > 0) {
                item.setQuantity(item.getQuantity() - 1);
                machine.setState(new AcceptingMoneyState());
            } else {
                System.out.println("Product out of stock");
                machine.setState(new OutOfStockState());
                machine.getState().handle(machine);
            }
        }
    }
}
