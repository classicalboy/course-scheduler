package com.example.geektrust.application;

/**
 * Write the error messages, warning messages and other info messages
 * to a log file
 */
public class Logger {
    String logFile = null;

    public Logger(){

    }

    public Logger(String logFile){
        this.logFile = logFile;
    }

    public void error(String message){
        System.out.println("Error occurred: " + message);
    }
}
