package io.javabrains.springbootquickstart.courseapi.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {
    @Autowired
    private TopicService topicService;
    @RequestMapping("/topics") //Get is the default HTTP method
    public List<Topic> getAllTopics(){
        return topicService.getTopics();
    }
    @RequestMapping("/topics/{topicId}")
    public Topic getTopic(@PathVariable("topicId") String id){
        return topicService.getTopic(id);
    }

    @RequestMapping(value="/topics", method= RequestMethod.POST)
    public void addTopic(@RequestBody Topic topic){
        topicService.addTopic(topic);
    }
    @RequestMapping(value="/topics/{id}", method= RequestMethod.PUT)
    public void updateTopic(@RequestBody Topic topic, @PathVariable String id){
        topicService.updateTopic(topic, id);
    }
    @RequestMapping(value="/topics/{id}", method= RequestMethod.DELETE)
    public void deleteTopic(@PathVariable String id){
        topicService.deleteTopic(id);
    }
}
