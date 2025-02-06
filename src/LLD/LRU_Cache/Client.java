package LLD.LRU_Cache;

public class Client {
    public static void main(String[] args) {
        Cache<Integer,Integer> cache1=new Cache<>(10,new LRUEvictionPolicy<>());
        cache1.put(2,3);
        cache1.put(2,4);
        System.out.println(cache1.get(2));
        System.out.println(cache1.get(3));

        Cache<Integer,String> cache2 =new Cache<>(10,new LRUEvictionPolicy<>());
        cache2.put(1,"Manthan");
        cache2.put(2,"Tanay");
        System.out.println(cache2.get(1));
        System.out.println(cache2.get(2));
        System.out.println(cache2.get(3));
    }
}
