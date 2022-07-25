package com.example.geektrust.application.utils;

public class CustomDate {
    private String dateString;
    private int year;
    private int month;
    private int day;

    public CustomDate(String dateString){
        this.dateString = dateString;
        this.day = Integer.parseInt(this.dateString.substring(0, 2));
        this.month = Integer.parseInt(this.dateString.substring(2, 4));
        this.year = Integer.parseInt(this.dateString.substring(4));
    }

    public  int getDay(){
        return day;
    }

    public  int getMonth(){
        return month;
    }

    public  int getYear(){
        return year;
    }
}
