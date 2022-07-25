package com.example.geektrust;

import com.example.geektrust.application.domain.constants.Messages;
import com.example.geektrust.application.domain.factory.CommandFactory;
import com.example.geektrust.application.domain.services.course.CourseOffering;



public class CommandExecutor {


    public void execute(String commandLine ) throws Exception {
        String[] commandLineData = commandLine.split(" ", 2);
        String command = commandLineData[0].replaceAll("-", "_").toUpperCase();
        CourseOffering courseOffering = CommandFactory.getObject(command);
        if(courseOffering.isValid(commandLineData[1])){
            courseOffering.run(commandLineData[1]);
        } else {
            System.out.println(String.valueOf(Messages.INPUT_DATA_ERROR));
        }
    }
}
