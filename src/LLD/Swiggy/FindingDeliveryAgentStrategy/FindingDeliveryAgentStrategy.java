package LLD.Swiggy.FindingDeliveryAgentStrategy;

import LLD.Swiggy.DeliveryAgent;

import LLD.Swiggy.Location;

import java.util.List;

public interface FindingDeliveryAgentStrategy {
 List<DeliveryAgent> findDeliveryAgents(Location passengerLocation );
}
