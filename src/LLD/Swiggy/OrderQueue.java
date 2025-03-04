package LLD.Swiggy;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OrderQueue {
    private  final Queue<Order> pendingOrders;
    private  final ExecutorService orderProcessingWorkers;
    private  DeliveryAgentService deliveryAgentService;
    public OrderQueue(DeliveryAgentService deliveryAgentService){
        pendingOrders=new ConcurrentLinkedQueue<>();
        orderProcessingWorkers=Executors.newFixedThreadPool(5);
        this.deliveryAgentService=deliveryAgentService;
    }
    public void addToQueue(Order order) {
        pendingOrders.offer(order);
    }
    public  void processOrderQueue(){
        while(!pendingOrders.isEmpty()){
            orderProcessingWorkers.submit(()-> {
                    System.out.println("🔄 Processing order from queue: ");
            deliveryAgentService.assignDeliveryAgent(pendingOrders.poll());}
            );
        }
    }
}
