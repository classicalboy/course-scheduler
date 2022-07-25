package com.example.geektrust.application.domain.services.course;

//REGISTER ANDY@GMAIL.COM OFFERING-JAVA-JAMES

import com.example.geektrust.application.domain.Course;
import com.example.geektrust.application.domain.Employee;
import com.example.geektrust.application.domain.constants.Messages;
import com.example.geektrust.application.domain.storage.Storage;

public class Register implements CourseOffering {

    public boolean isValid(String inputString){
        String[] arguments = inputString.split(" ");
        if(arguments.length != 2){
            return false;
        }
        return true;
    }

    public String run(String inputString){
        String[] arguments = inputString.split(" ");
        Employee employee = new Employee(arguments[0]);
        Course course = Storage.courses.get(arguments[1]);
        String registrationId = course.register(employee.getEmailId());
        if(registrationId.equals(String.valueOf(Messages.COURSE_FULL_ERROR))){
            System.out.println(registrationId);
        } else {
            Storage.registerations.put(registrationId, course.getCourseOfferingId());
            System.out.println(registrationId + " " + "ACCEPTED");
        }
        return null;
    }
}
