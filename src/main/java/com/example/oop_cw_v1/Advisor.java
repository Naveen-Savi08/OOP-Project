package com.example.oop_cw_v1;

import javafx.scene.control.Label;

import java.util.HashMap;

public class Advisor extends User{
    private  String advisorID;
    public Advisor(String firstName, String lastName, String gender, String DoB, String contactNumber, String email, String password, String advisorID) {
        super(firstName, lastName, gender, String.valueOf(DoB),contactNumber,email,password);
        this.advisorID = advisorID;
    }

    // getters and setters for advisor id.

    public Advisor(){
    }

    public String getAdvisorID() {
        return advisorID;
    }

    public void setAdvisorID(String advisorID) {
        this.advisorID = advisorID;
    }

    @Override
    public void displayUserInformation(String memberID, Label firstName, Label lastName, Label gender, Label DoB, Label contactNumber, Label email,Label advisorID) {
        HashMap<String,String> dataMap = DatabaseConnection.getAdvisorData(memberID);
        firstName.setText(dataMap.get("First Name"));
        lastName.setText(dataMap.get("Last Name"));
        gender.setText(dataMap.get("Gender"));
        DoB.setText(dataMap.get("DOB"));
        contactNumber.setText(dataMap.get("Contact Number"));
        email.setText(dataMap.get("Email"));
        advisorID.setText(dataMap.get("Advisor ID"));


    }
}
