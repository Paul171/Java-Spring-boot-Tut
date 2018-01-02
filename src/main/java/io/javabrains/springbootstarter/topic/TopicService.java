package io.javabrains.springbootstarter.topic;
//Business service are singleton in spring

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Once the server starts, it will create an instance for @service classes
@Service
public class TopicService {
    private List<Topic> topics = new ArrayList<>(Arrays.asList(new Topic("Java","java","description"),
            new Topic("Java","java2e","description"),
            new Topic("Java","java3e","description")));
    public List<Topic> getTopics(){
        return topics;
    }
    public Topic getTopic(String id){
        return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
    }
    public void addTopic(Topic topic){
        topics.add(topic);
    }

    public void updateTopic(Topic topic, String id) {
        for (int i = 0; i < topics.size(); i++){
            Topic t = topics.get(i);
            if(t.getId().equals(id)){
                topics.set(i, topic);
            }
        }
    }

    public void deleteTopic(String id) {
        topics.removeIf(t->t.getId().equals(id));
    }
}
