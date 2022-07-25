package com.example.geektrust.application.domain;

import com.example.geektrust.application.domain.constants.CourseOfferedStatus;

public class CourseRegisteredEmployee {
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public CourseOfferedStatus getCourseOfferedStatus() {
        return courseOfferedStatus;
    }

    public void setCourseOfferedStatus(CourseOfferedStatus courseOfferedStatus) {
        this.courseOfferedStatus = courseOfferedStatus;
    }

    private CourseOfferedStatus courseOfferedStatus;

    public CourseRegisteredEmployee(Employee employee, CourseOfferedStatus courseOfferedStatus){
        this.employee = employee;
        this.courseOfferedStatus = courseOfferedStatus;
    }
}
