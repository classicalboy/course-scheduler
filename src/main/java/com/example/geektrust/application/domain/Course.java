package com.example.geektrust.application.domain;

import com.example.geektrust.application.domain.constants.CourseStatus;
import com.example.geektrust.application.domain.constants.Messages;
import com.example.geektrust.application.utils.CustomDate;

import java.util.HashMap;

public class Course {
   private final String title;
   private final String instructor;
   private final String dateString;

    public CustomDate getCourseDate() {
        return courseDate;
    }

    private final CustomDate courseDate;
   private final int minEmployees;
   private final int maxEmployees;

   private final String courseOfferingId;
   private final HashMap<String, Employee> registeredEmployees = new HashMap<>();
   private CourseStatus status;

    public Course(String title, String instructorName, String dateString, String minEmployees, String maxEmployees){
        this.title = title;
        this.instructor = instructorName;
        this.dateString = dateString;
        this.courseDate = new CustomDate(dateString);
        this.minEmployees = Integer.parseInt(minEmployees);
        this.maxEmployees = Integer.parseInt(maxEmployees);
        this.courseOfferingId = "OFFERING-" + this.title + "-" + this.instructor;
        this.status = CourseStatus.OFFERED;
    }

    public CourseStatus getStatus() {
        return status;
    }

    public void setStatus(CourseStatus status) {
        this.status = status;
    }

    public String getDateString() {
        return dateString;
    }

    public String getCourseOfferingId() {
        return courseOfferingId;
    }

    public HashMap<String, Employee> getRegisteredEmployees(){
        return registeredEmployees;
    }

   public String getTitle(){
     return title;
   }

   public String getInstructor(){
     return instructor;
   }

    public int getMinEmployees(){
     return minEmployees;
   }

   public int getMaxEmployees(){
     return maxEmployees;
   }

   public String register(String emailId){
       if(status == CourseStatus.COURSE_FULL) {
           return String.valueOf(Messages.COURSE_FULL_ERROR);
       }

       Employee employee = new Employee(emailId);
       String registrationId = "REG-COURSE-" + employee.getName() + "-" + title;
       registeredEmployees.put(registrationId, employee);

       if(registeredEmployees.size() == maxEmployees) status = CourseStatus.COURSE_FULL;
       return registrationId;
   }

   public String cancel(String registrationId){
        if(status == CourseStatus.CONFIRMED){
            return String.valueOf(Messages.CANCEL_REJECTED);
        }
        this.getRegisteredEmployees().remove(registrationId);
        return String.valueOf(Messages.CANCEL_ACCEPTED);
   }
}
