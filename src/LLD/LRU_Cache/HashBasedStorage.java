package LLD.LRU_Cache;

import java.util.HashMap;
import java.util.Map;

public class HashBasedStorage<Key,Value> implements IStorage<Key,Value>{
    int capacity;
    Map<Key,Value> storage;

    public HashBasedStorage(int capacity) {
        this.capacity = capacity;
        this.storage=new HashMap<>();
    }

    @Override
    public void put(Key key, Value value) {
        if(!storage.containsKey(key) && isCapacityFull()) // if it is a new Key , we need to check for capacity, and capacity is full then we will throw exception
            throw new StorageFullException("Capacity of cache is full");
         // if key is already present ,then we dont need to check capacity because we will be only replacing value of that key
        //and if we have capacity then it will be added easily.
       storage.put(key,value);
    }

    @Override
    public Value get(Key key) {
     if(storage.containsKey(key)){
         return storage.get(key); //if key is present , we will return it
     }
     throw new NotFoundException("Key not present in Cache"); //otherwise user is trying to get the key which is not presentl
    }

    @Override
    public void remove(Key key) {
        storage.remove(key);
    }
    public boolean isCapacityFull(){
        return this.capacity == this.storage.size();
    }
}
