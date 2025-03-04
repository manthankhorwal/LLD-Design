package LLD.Swiggy;

import LLD.Swiggy.DeliveryAgentStorage.DeliveryAgentStorage;
import LLD.Swiggy.DeliveryAgentStorage.InMemoryDeliveryAgentStorage;
import LLD.Swiggy.FindingDeliveryAgentStrategy.FindingDeliveryAgentStrategy;
import LLD.Swiggy.FindingDeliveryAgentStrategy.TraversalDeliveryAgentFind;
import LLD.Swiggy.IdGeneration.IdGenerationStrategy;
import LLD.Swiggy.IdGeneration.UUIDGeneration;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FoodDeliveryService {
 private static volatile FoodDeliveryService instance;
 private final Map<String,Customer> customers;
 private final Map<String,Restaurant> restaurants;
 private final Map<String,Order> orders;
 private DeliveryAgentStorage deliveryAgentStorage;
private IdGenerationStrategy idGenerationStrategy;
private DeliveryAgentService deliveryAgentService;
private OrderQueue orderQueue;
 private FoodDeliveryService(){
     customers=new ConcurrentHashMap<>();
     restaurants=new ConcurrentHashMap<>();
     orders=new HashMap<>();
    idGenerationStrategy=new UUIDGeneration();
     deliveryAgentStorage=new InMemoryDeliveryAgentStorage();
     deliveryAgentService=new DeliveryAgentService(new TraversalDeliveryAgentFind(deliveryAgentStorage));
     orderQueue=new OrderQueue(deliveryAgentService);
 }
 public static FoodDeliveryService getInstance(){
     if(instance==null){
       synchronized (FoodDeliveryService.class){
           if(instance==null){
               instance=new FoodDeliveryService();
           }
       }
     }
     return instance;
 }
 public void setDeliveryAgentStorageStrategy(DeliveryAgentStorage deliveryAgentStorage){
     this.deliveryAgentStorage=deliveryAgentStorage;
 }
    public void setFindingDeliveryAgentService(FindingDeliveryAgentStrategy findingDeliveryAgentService){
       deliveryAgentService.setFindingAgentStrategy(findingDeliveryAgentService);
    }
 public void registerCustomer(Customer customer){
     customers.put(customer.getEmail(),customer);
 }
    public void registerRestaurant(Restaurant restaurant) {
        restaurants.put(restaurant.getId(), restaurant);
    }

    public void registerDeliveryAgent(DeliveryAgent agent){
     deliveryAgentStorage.addDeliveryAgent(agent);
 }
public void placeOrder(Customer customerId, String restaurantId, List<OrderItem> items,Location deliveryLocation){
  Customer customer=customers.get(customerId);
  Restaurant restaurant = restaurants.get(restaurantId);
  if(customer==null || restaurant==null)
      return;
  Order order= new Order(idGenerationStrategy.provideID(),customer,restaurant,deliveryLocation);
  orders.put(order.getId(),order);
  orderQueue.addToQueue(order);
 }

}
