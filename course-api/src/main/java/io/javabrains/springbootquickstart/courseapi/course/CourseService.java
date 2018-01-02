package io.javabrains.springbootquickstart.courseapi.course;
//Business service are singleton in spring

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//Once the server starts, it will create an instance for @service classes
@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
//    private List<Course> topics = new ArrayList<>(Arrays.asList(new Course("Java","java","description"),
//            new Course("Java","java2e","description"),
//            new Course("Java","java3e","description")));
    public List<Course> getAllCourses(String topicId){
        //return courses;
        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(topicId).iterator().forEachRemaining(courses::add);
        return courses;

    }
    public Course getCourse(String id){
        //return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
        return courseRepository.findOne(id);
    }
    public void addCourse(Course course){
        //topics.add(course);
        courseRepository.save(course);

    }

    public void updateCourse(Course course) {
//        for (int i = 0; i < topics.size(); i++){
//            Course t = topics.get(i);
//            if(t.getId().equals(id)){
//                topics.set(i, course);
//            }
//        }
        courseRepository.save(course);
    }

    public void deleteCourse(String id) {
        //topics.removeIf(t->t.getId().equals(id));
        courseRepository.delete(id);
    }
}
