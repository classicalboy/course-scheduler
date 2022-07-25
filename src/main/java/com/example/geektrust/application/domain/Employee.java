package com.example.geektrust.application.domain;

import java.io.Serializable;

public class Employee {
  private String name;
  private String emailId;

  public Employee(){

  }

  public Employee(String emailId){

      this.emailId = emailId;
      String[] arrOfStr = emailId.split("@", 2);
      this.name = arrOfStr[0];
  }

  public String getName(){
   return name;
  }

  public String getEmailId() { return emailId; }

}
