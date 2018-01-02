package io.javabrains.springbootquickstart.courseapi.topic;
//Business service are singleton in spring

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Once the server starts, it will create an instance for @service classes
@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;
//    private List<Course> topics = new ArrayList<>(Arrays.asList(new Course("Java","java","description"),
//            new Course("Java","java2e","description"),
//            new Course("Java","java3e","description")));
    public List<Topic> getTopics(){
        //return topics;
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().iterator().forEachRemaining(topics::add);
        return topics;

    }
    public Topic getTopic(String id){
        //return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
        return topicRepository.findOne(id);
    }
    public void addTopic(Topic topic){
        //topics.add(topic);
        topicRepository.save(topic);

    }

    public void updateTopic(Topic topic, String id) {
//        for (int i = 0; i < topics.size(); i++){
//            Course t = topics.get(i);
//            if(t.getId().equals(id)){
//                topics.set(i, topic);
//            }
//        }
        topicRepository.save(topic);
    }

    public void deleteTopic(String id) {
        //topics.removeIf(t->t.getId().equals(id));
        topicRepository.delete(id);
    }
}
