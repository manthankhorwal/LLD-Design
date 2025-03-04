package LLD.Swiggy.DeliveryAgentStorage;

import LLD.Swiggy.DeliveryAgent;
import LLD.Swiggy.Location;
import LLD.Uber.Driver;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryDeliveryAgentStorage implements DeliveryAgentStorage {
  private ConcurrentHashMap<String,DeliveryAgent> deliveryAgents;
  public InMemoryDeliveryAgentStorage(){
      deliveryAgents=new ConcurrentHashMap<>();
  }


    @Override
    public void addDeliveryAgent(DeliveryAgent deliveryAgent) {
        deliveryAgents.put(deliveryAgent.getPhone(),deliveryAgent);
    }

    @Override
    public Map<String, DeliveryAgent> getDeliveryAgent() {
        return deliveryAgents;
    }

    @Override
    public void removeDeliveryAgent(String deliveryAgentId) {
        if(deliveryAgents.containsKey(deliveryAgentId)) {
            deliveryAgents.remove(deliveryAgentId);
        }
    }

    @Override
    public void updateDeliveryAgentLocation(String deliveryAgentid,Location location) {
      if(deliveryAgents.containsKey(deliveryAgentid)){
          deliveryAgents.get(deliveryAgentid).setLocation(location);
      }
    }
}
