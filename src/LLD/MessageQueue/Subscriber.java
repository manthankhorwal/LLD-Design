package LLD.MessageQueue;

public class Subscriber {
    private String id;
 public Subscriber(String id){
     this.id=id;
 }
    public void consume(Message message){
        System.out.println("Subscriber "+id+" is consuming the message "+message);
    }
}
