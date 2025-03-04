package LLD.MessageQueue;

import java.util.HashMap;
import java.util.Map;

public class Client {
    public static void main(String[] args) {
        MessageQueue mq = new MessageQueue();
        mq.createTopic("Manthan");
        mq.createTopic("Foods");
        Subscriber sb1 = new Subscriber("1");
        Subscriber sb2 = new Subscriber("2");
        Subscriber sb3 = new Subscriber("3");
        Subscriber sb4 = new Subscriber("4");
        mq.subscribeTopic("Manthan", sb1);
        mq.subscribeTopic("Manthan", sb2);
        mq.subscribeTopic("Foods", sb3);
        mq.subscribeTopic("Foods", sb2);
        mq.subscribeTopic("Foods", sb4);
        mq.send("Manthan",new Message("How are you"));
        mq.send("Foods",new Message("process Price"));
        Map<String,String> m=new HashMap<>();

    }
}
