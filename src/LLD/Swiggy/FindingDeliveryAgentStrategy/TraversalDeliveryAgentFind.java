package LLD.Swiggy.FindingDeliveryAgentStrategy;

import LLD.Swiggy.DeliveryAgent;

import LLD.Swiggy.DeliveryAgentStorage.DeliveryAgentStorage;
import LLD.Swiggy.Location;
import java.util.List;

public class TraversalDeliveryAgentFind implements FindingDeliveryAgentStrategy {
    //This strategy is used to show a flow in interview , which will normally take an map , and find available deliveryAgents from it.
    //Here we will use InMemory storage , to get the map and find nearby deliveryAgents
    DeliveryAgentStorage deliveryAgentstorage;
    public TraversalDeliveryAgentFind(DeliveryAgentStorage deliveryAgentStorageStrategy){
        this.deliveryAgentstorage=deliveryAgentStorageStrategy;
    }
    //By using this we dont need to pass a deliveryAgents list, you can see in previous commits that we are passing a driver list to get the available deliveryAgents.
    // but now this Driver finding traversal will use inMemory storage , and GepSpatial strategy will use remote database to get the list of deliveryAgents and find closest.

    @Override
    public List<DeliveryAgent> findDeliveryAgents(Location passengerLocation) {

return null;
    }

    

}
