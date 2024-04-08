package com.example.oop_cw_v1;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Date;

public class AttendanceData {
    private final SimpleStringProperty studentID;
    private final SimpleStringProperty firstName;
    private final SimpleStringProperty lastName;
    private final SimpleBooleanProperty attendance;
    private final SimpleStringProperty eventID;
    private Date attendance_date;
    private String event_name;
    private String event_id;
    private String student_id;
    private String first_name;
    private String last_name;
    private boolean is_present;

    //Default constructor
    public AttendanceData() {
        this.studentID = new SimpleStringProperty("");
        this.firstName = new SimpleStringProperty("");
        this.lastName = new SimpleStringProperty("");
        this.attendance = new SimpleBooleanProperty(false);
        this.eventID = new SimpleStringProperty("");
    }

    // Constructor with eventID
    public AttendanceData(String studentID, String firstName, String lastName, boolean attendance, String eventID) {
        this.studentID = new SimpleStringProperty(studentID);
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.attendance = new SimpleBooleanProperty(attendance);
        this.eventID = new   SimpleStringProperty(eventID);
    }

    // Constructor without eventID
    public AttendanceData(String studentID, String firstName, String lastName, boolean attendance) {
        this.studentID = new SimpleStringProperty(studentID);
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.attendance = new SimpleBooleanProperty(attendance);
        this.eventID = new SimpleStringProperty("");
    }


    // Getters and setters
    public String getStudentID() {
        return studentID.get();
    }

    public SimpleStringProperty studentIDProperty() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID.set(studentID);
    }

    public String getStudentFirstName() {
        return firstName.get();
    }

    public SimpleStringProperty studentFirstNameProperty() {
        return firstName;
    }

    public void setStudentFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getStudentLastName() {
        return lastName.get();
    }

    public SimpleStringProperty studentLastNameProperty() {
        return lastName;
    }

    public void setStudentLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public boolean getAttendance() {
        return attendance.get();
    }

    public SimpleBooleanProperty attendanceProperty() {
        return attendance;
    }

    public void setAttendance(boolean attendance) {
        this.attendance.set(attendance);
    }

    public String getEventID() {
        return eventID.get();
    }

    public SimpleStringProperty eventIDProperty() {
        return eventID;
    }

    public void setEventID(String eventID) {
        this.eventID.set(eventID);
    }

    public Date getAttendance_date() {
        return attendance_date;
    }

    public void setAttendance_date(Date attendanceDate) {
        this.attendance_date = attendanceDate;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String eventName) {
        this.event_name = eventName;
    }

    public String getEvent_id() {
        return event_id;
    }

    public void setEvent_id(String event_id) {
        this.event_id = event_id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public boolean isIs_present() {
        return is_present;
    }

    public void setIs_present(boolean is_present) {
        this.is_present = is_present;
    }
}

