package com.example.geektrust.application.domain.services.course;


public interface CourseOffering {

    public boolean isValid(String command) throws Exception;

    public String run(String inputString);
}
