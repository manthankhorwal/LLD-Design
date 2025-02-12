package LLD.VendingMachine;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    Map<Integer,Item> items=new HashMap<>();

    public void addItem(Item item){
        items.put(item.getCode(),item);
    }
    public Item getItem(int code) {
        return items.get(code);
    }
    public boolean isCodeValid(int code){
        return items.containsKey(code);
    }
    public void updateStock(int code){
        Item item=items.get(code);
        if(item!=null && item.getQuantity()>0){
            item.setQuantity(item.getQuantity()-1);
            System.out.println("Stock Updated "+item.getName());
        }else{
            System.out.println("Item out of stock");
        }
    }


}
