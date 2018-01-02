package io.javabrains.springbootquickstart.courseapi.course;

import io.javabrains.springbootquickstart.courseapi.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @RequestMapping("/topics/{topicId}/courses")
    public List<Course> getAllCourses(@PathVariable("topicId") String id){
        return courseService.getAllCourses(id);
    }

    @RequestMapping(value="/topics/{topicId}/courses/{courseId}")
    public Course getCourse(@PathVariable String courseId){
        return courseService.getCourse(courseId);
    }
    @RequestMapping(value="/topics/{topicId}/courses", method = RequestMethod.POST)
    public void addCourse(@RequestBody Course course, @PathVariable String topicId){
        course.setTopic(new Topic(topicId, "", ""));
        courseService.addCourse(course);
    }

    @RequestMapping(value="/topics/{topicId}/courses/{courseId}", method= RequestMethod.PUT)
    public void updateCourse(@RequestBody Course course, @PathVariable String topicId){
        course.setTopic(new Topic(topicId,"",""));
        courseService.updateCourse(course);
    }
    @RequestMapping(value="/topics/{topicId}/courses/{courseId}", method= RequestMethod.DELETE)
    public void deleteCourse(@PathVariable String courseId){
        courseService.deleteCourse(courseId);
    }
}
