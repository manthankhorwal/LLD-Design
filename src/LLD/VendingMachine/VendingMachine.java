package LLD.VendingMachine;

public class VendingMachine {

    private State state;
    private Inventory inventory;
    int balance;
    int selectedItemCode;

    VendingMachine() {
        state = new IdleState();
        state.handle(this);
        inventory = new Inventory();
        this.balance = 0;
        loadInventory();
    }

    private void loadInventory() {
        inventory.addItem(new Item("Coke", 101, 10, 5));
        inventory.addItem(new Item("Chips", 102, 15, 3));
        inventory.addItem(new Item("Candy", 103, 5, 10));
    }
    public void selectedItem(int code){
        selectedItemCode=code;
        setState(new SelectingItemState());
        state.handle(this);

    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void insertMoney(int amount){
        balance+=amount;
        setState(new AcceptingMoneyState());
        state.handle(this);
        if(balance>0) {
            setState(new RefundState());
            state.handle(this);
        }
    }
    public Inventory getInventory(){
        return inventory;
    }
    public State getState(){
        return state;
    }
    public int getBalance(){
        return balance;
    }
    public void setState(State state){
        this.state=state;
    }
    public int getSelectedItemCode(){
        return selectedItemCode;
    }


}
