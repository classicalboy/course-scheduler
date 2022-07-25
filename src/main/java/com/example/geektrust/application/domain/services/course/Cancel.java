package com.example.geektrust.application.domain.services.course;

import com.example.geektrust.application.domain.Course;
import com.example.geektrust.application.domain.constants.Messages;
import com.example.geektrust.application.domain.storage.Storage;

public class Cancel implements CourseOffering {

    public boolean isValid(String inputString){
        String[] arguments = inputString.split(" ");
        if(arguments.length != 1){
            return false;
        }
        return true;
    }

    public String run(String inputString){
        // inputString is registrationId for Cancel command
        String courseId = Storage.registerations.get(inputString);
        if(courseId != null){
            Course course = Storage.courses.get(courseId);
            if(course != null){
                System.out.println(course.cancel(inputString));
                Storage.courses.put(courseId, course);
            } else {
                System.out.println(Messages.INPUT_DATA_ERROR);
            }
        } else {
            System.out.println(Messages.INPUT_DATA_ERROR);
        }
        return null;
    }
}
