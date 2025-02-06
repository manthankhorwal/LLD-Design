package LLD.LRU_Cache;

import java.util.HashMap;
import java.util.Map;

public class LRUEvictionPolicy<Key> implements IEvictionPolicy<Key> {
    private DoubleLinkedList<Key> list;  // list to keep the keys present in cache right now in order , from this list we can check if element was recently used and is not used recently
    private Map<Key,DoublyLinkedListNode<Key>> mapper;   //this is to make accessing the doublyLinkedList node at O(1)
    public LRUEvictionPolicy(){
        list = new DoubleLinkedList<>();
        mapper = new HashMap<>();
    }
    @Override
    public void keyAccessed(Key key) { //this method will put the key to recently used
    if(mapper.containsKey(key)){
        list.removeNode(mapper.get(key)); // it is already in Cache , but we need to make it to recently used , so we will remove that node from list and create new node and put it as most recently used
    }
      DoublyLinkedListNode<Key> newNode= list.addAtLast(key); // adding to most recently used
        mapper.put(key,newNode); // adding new node address
    }

    @Override
    public Key evictKey() {
     Key keyRemoved = list.removeFromFirst(); // this will remove it from LRU cache list Least Recently Used
     mapper.remove(keyRemoved); //remove it from mapper as well
     return keyRemoved;  //to remove it from Cache storage as well
    }
}
