package io.javabrains.springbootstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourseApiApp {
    public static void main(String[] args){
        //pass: the name of class, and args
        SpringApplication.run(CourseApiApp.class, args);
    }
}

