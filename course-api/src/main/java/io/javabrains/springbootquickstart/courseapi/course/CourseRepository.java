package io.javabrains.springbootquickstart.courseapi.course;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
public interface CourseRepository extends CrudRepository<Course, String> {
    //getAllTopics()
    //getTopic(String id)
    //updateTopic(Course t)
    //deleteTopic(String id)
    public List<Course> findByTopicId(String topicId);
}
