package com.example.geektrust.application.domain.factory;

import com.example.geektrust.application.domain.constants.Commands;
import com.example.geektrust.application.domain.services.course.*;

public class CommandFactory {

    public static CourseOffering getObject(String commandType) throws Exception {
        Commands cmd = Commands.valueOf(commandType);

        switch (cmd){
            case ADD_COURSE_OFFERING:
                return new Add();

            case REGISTER:
                return new Register();

            case CANCEL:
                return new Cancel();

            case ALLOT_COURSE:
            case ALLOT:
                return new Allot();

            default:
                throw new Exception("illegal command");
        }
    }
}
