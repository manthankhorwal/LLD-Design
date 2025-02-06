package LLD.LRU_Cache;

public interface IStorage<Key,Value> {
    void put(Key key,Value value);
    Value get(Key key);
    void remove(Key key);

}
