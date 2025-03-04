package LLD.MessageQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class Topic {
    private String topicName;
   private Queue<Message> messages;
   private ConcurrentLinkedQueue<Subscriber> subscribers;
   private ReentrantLock lock;
   private ExecutorService executor;
    public Topic(String topicName){
        this.topicName=topicName;
        messages=new ConcurrentLinkedQueue<>();
        subscribers =new ConcurrentLinkedQueue<>();
        lock=new ReentrantLock();
        executor= Executors.newCachedThreadPool();

    }
    public void addMessage(Message message){
            messages.offer(message);
            notifySubscribers(message);

    }
    public void notifySubscribers(Message message){
        for(Subscriber subscriber : subscribers){
            executor.submit(()-> subscriber.consume(message));
        }
    }
    public void addSubscriber(Subscriber subscriber){
        subscribers.add(subscriber);
    }
    public void removeSubscriber(Subscriber subscriber){
        subscribers.remove(subscriber);
    }
}
