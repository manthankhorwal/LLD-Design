package LLD.LRU_Cache;

import java.util.Map;

public class Cache<Key,Value> {
   IStorage<Key,Value> storage;  //storage to store key and value pairs
   IEvictionPolicy<Key> policy;
   public Cache(int capacity,IEvictionPolicy<Key> policy){
       storage=new HashBasedStorage<>(capacity);
       this.policy=policy;
   }
   public void put(Key key,Value value){ //this method will work for both if element is new or asking for update the value of particular key.
       try {
           this.storage.put(key, value); //this will throw exception if capacity is pull
           policy.keyAccessed(key);
       }catch (StorageFullException exp){
           System.out.println(exp.getMessage());
           Key keyToRemove = policy.evictKey(); //capacity is full , so we will remove Least Recently Used key
           this.storage.remove(keyToRemove); // and also remove it from cache as well
           put(key,value); //now we have capacity to add new key
       }
   }
   public Value get(Key key){
       Value value;
       try{
       value = this.storage.get(key);
       policy.keyAccessed(key); //the element is accessed , means we need to put it in Recently used
       }catch (NotFoundException exp){
           System.out.println(exp.getMessage());
           value = null;
       }
       return value;
   }
}
