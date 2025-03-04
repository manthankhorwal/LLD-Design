package LLD.Swiggy;

import LLD.Swiggy.FindingDeliveryAgentStrategy.FindingDeliveryAgentStrategy;


import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

   public class DeliveryAgentService {
    private final ExecutorService agentRequestService ;
    private FindingDeliveryAgentStrategy strategy;
   public DeliveryAgentService(FindingDeliveryAgentStrategy strategy){
        agentRequestService=Executors.newFixedThreadPool(5);

    }
       public void setFindingAgentStrategy(FindingDeliveryAgentStrategy findingAgentStrategy){
           strategy=findingAgentStrategy;
       }
       public void assignDeliveryAgent(Order order) {
           List<DeliveryAgent> availableAgents = strategy.findDeliveryAgents(order.getDeliveryLocation());
           if (availableAgents.isEmpty()) {
               System.out.println("⚠️ No agents available");
           }
           List<Callable<DeliveryAgent>> agentTasks = availableAgents.stream()
                   .map(agent -> (Callable<DeliveryAgent>) () -> requestAgentAcceptance(agent, order))
                   .toList();

           try {
               DeliveryAgent assignedAgent = agentRequestService.invokeAny(agentTasks);
               synchronized (assignedAgent) {
                   if (assignedAgent.isAvailable()) {
                       order.assignDeliveryAgent(assignedAgent);
                       System.out.println("🚴 Assigned " + assignedAgent.getName() + " to Order: " + order.getId());
                   }
               }
           } catch (Exception e) {
               System.out.println("❌ No agent accepted order: " + order.getId());
               //order back to queue

           }
       }

       private static DeliveryAgent requestAgentAcceptance(DeliveryAgent agent, Order order) throws InterruptedException {
           Thread.sleep(new Random().nextInt(2000) + 500);
           return new Random().nextBoolean() ? agent : null;
       }

}
