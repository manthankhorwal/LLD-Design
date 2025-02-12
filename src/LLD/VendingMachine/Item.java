package LLD.VendingMachine;

public class Item {
   private String name;
   private int code;
   private int price;
   private int quantity;

    public Item(String name, int code, int price, int quantity) {
        this.name = name;
        this.code = code;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() { return name; }
    public int getCode() { return code; }
    public int getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
