package LLD.Swiggy;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final String id;
    private final Customer customer;
    private final Restaurant restaurant;
    private final List<OrderItem> items;
    private OrderStatus status;
    private DeliveryAgent deliveryAgent;
    private final Location deliveryLocation;

    public Order(String id, Customer customer, Restaurant restaurant, Location deliveryLocation) {
        this.id = id;
        this.customer = customer;
        this.restaurant = restaurant;
        this.deliveryLocation = deliveryLocation;
        this.items = new ArrayList<>();
        this.status = OrderStatus.PENDING;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public void assignDeliveryAgent(DeliveryAgent agent) {
        this.deliveryAgent = agent;
    }

    public String getId() { return id; }
    public Location getDeliveryLocation() { return deliveryLocation; }
}
