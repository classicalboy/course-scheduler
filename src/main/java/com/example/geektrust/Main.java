package com.example.geektrust;

import com.example.geektrust.application.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static Logger log;

    public static void main(String[] args) {
        log = new Logger();
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(args[0]);
            Scanner sc = new Scanner(inputStream);
            CommandExecutor commandExecutor = new CommandExecutor();
            while (sc.hasNextLine()) {
                commandExecutor.execute(sc.nextLine());
            }
            sc.close();
            inputStream.close();
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    log.error(e.getMessage());
                }
            }
        }
    }
}
