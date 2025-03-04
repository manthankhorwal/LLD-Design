package LLD.MessageQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MessageQueue {
    Map<String,Topic> topics;
    MessageQueue(){
        topics=new ConcurrentHashMap<>();
    }

    public void createTopic(String topicName){
        if(topics.containsKey(topicName)) {
            System.out.println("Topic already present");
        }
        topics.putIfAbsent(topicName,new Topic(topicName));

    }
    public void send(String topicName , Message message){
        if(!topics.containsKey(topicName)) {
            System.out.println("Topic not present");
        }
        topics.get(topicName).addMessage(message);
    }
    public void subscribeTopic(String topicName , Subscriber subscriber){
    topics.get(topicName).addSubscriber(subscriber);
    }
    public void unsubscribeTopic(String topicName, Subscriber subscriber) {
        Topic topic = topics.get(topicName);
        if (topic == null) {
            System.out.println("Topic not found: " + topicName);
            return;
        }
        topic.removeSubscriber(subscriber);
    }
}
