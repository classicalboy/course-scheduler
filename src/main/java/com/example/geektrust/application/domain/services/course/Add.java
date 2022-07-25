package com.example.geektrust.application.domain.services.course;

import com.example.geektrust.application.domain.Course;
import com.example.geektrust.application.domain.storage.Storage;

public class Add implements CourseOffering{


    public boolean isValid(String inputString){
        String[] arguments = inputString.split(" ");
        if(arguments.length != 5){
            return false;
        }
        return true;
    }

    public String run(String inputString){
        String[] arguments = inputString.split(" ");
        Course course = new Course(arguments[0], arguments[1], arguments[2], arguments[3], arguments[4]);
        Storage.courses.put(course.getCourseOfferingId(), course);
        System.out.println(course.getCourseOfferingId());
        return null;
    }
}
