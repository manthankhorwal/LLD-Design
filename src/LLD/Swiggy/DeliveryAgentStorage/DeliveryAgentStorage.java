package LLD.Swiggy.DeliveryAgentStorage;

import LLD.Swiggy.DeliveryAgent;
import LLD.Swiggy.Location;


import java.util.Map;

public interface DeliveryAgentStorage {
    void addDeliveryAgent(DeliveryAgent deliveryAgent);
    Map<String,DeliveryAgent> getDeliveryAgent();
    void removeDeliveryAgent(String deliveryAgentId);
    void updateDeliveryAgentLocation(String deliveryAgent, Location location);
}
