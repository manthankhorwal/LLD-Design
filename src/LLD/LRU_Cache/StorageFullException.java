package LLD.LRU_Cache;

public class StorageFullException extends RuntimeException{
    public StorageFullException(String msg){
        super(msg);
    }
}
