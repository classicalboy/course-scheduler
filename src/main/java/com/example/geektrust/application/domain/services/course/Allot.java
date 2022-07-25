package com.example.geektrust.application.domain.services.course;

import com.example.geektrust.application.domain.Course;
import com.example.geektrust.application.domain.Employee;
import com.example.geektrust.application.domain.constants.CourseStatus;
import com.example.geektrust.application.domain.constants.Messages;
import com.example.geektrust.application.domain.storage.Storage;

import java.util.HashMap;
import java.util.Map;

public class Allot implements CourseOffering {

    public boolean isValid(String inputString){
        String[] arguments = inputString.split(" ");
        if(arguments.length != 1){
            return false;
        }
        return true;
    }

    public String run(String inputString){
        // inputString is courseId for Allot command
        Course course = Storage.courses.get(inputString);
        if(course != null){
            HashMap<String, Employee> registeredEmployees = course.getRegisteredEmployees();
            if(course.getMinEmployees() > registeredEmployees.size()) {
                course.setStatus(CourseStatus.COURSE_CANCELED);
            } else {
                course.setStatus(CourseStatus.CONFIRMED);
            }
            Storage.courses.put(course.getCourseOfferingId(), course);
            for (Map.Entry<String, Employee> entry : registeredEmployees.entrySet()){
                String registrationId = entry.getKey();
                Employee employee = entry.getValue();

                System.out.println(registrationId + " " + employee.getEmailId()
                    + " " + course.getCourseOfferingId() + " " + course.getTitle()
                    + " " + course.getInstructor() + " " + course.getDateString()
                    + " " + course.getStatus());
            }
        } else {
            System.out.println(Messages.INPUT_DATA_ERROR);
        }

        return null;
    }
}
