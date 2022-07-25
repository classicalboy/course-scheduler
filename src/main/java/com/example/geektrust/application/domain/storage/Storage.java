package com.example.geektrust.application.domain.storage;

import com.example.geektrust.application.domain.Course;
import com.example.geektrust.application.domain.Employee;

import java.util.ArrayList;
import java.util.HashMap;

public class Storage {

    public ArrayList<Employee> employees = new ArrayList<Employee>();;
    public static HashMap<String, Course> courses = new HashMap<String, Course>();
    public static HashMap<String, String> registerations = new HashMap<String, String>();
}
