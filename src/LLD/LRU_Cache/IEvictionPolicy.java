package LLD.LRU_Cache;

public interface IEvictionPolicy<Key> {
   void keyAccessed(Key key);
   Key evictKey();
}
