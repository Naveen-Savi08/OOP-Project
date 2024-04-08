package com.example.oop_cw_v1;

import javafx.scene.control.Label;

import java.util.Date;

public abstract class User {

    // common attributes of user
    private String firstName;
    private String lastName;
    private String gender;
    private String DoB;

    private String contactNumber;
    private String email;
    private String password;



    //Constructor for user
    public User(String firstName, String lastName, String gender, String DoB, String contactNumber, String email, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.DoB = DoB;
        this.email = email;
        this.password = password;
        this.contactNumber = contactNumber;
    }

    public User(){

    }


    // getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDoB() {
        return DoB;
    }

    public void setDoB(Date DOB) {
        this.DoB = String.valueOf(DOB);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }


    // abstract methods
    public abstract void displayUserInformation(String memberID,Label firstNameLabel, Label lastNameLabel, Label genderLabel, Label DoBLabel, Label contactNumberLabel, Label emailLabel, Label UserIdLabel );




}
