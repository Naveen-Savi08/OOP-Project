package com.example.oop_cw_v1;

import java.time.LocalDateTime;
import java.util.Date;

public class Meeting extends MainSchedule {
    private String meetingType;


    public Meeting(String scheduleId, String scheduleName, String scheduleLocation, String clubId, String scheduleDate, String scheduleTime, String meetingType) {
        super(scheduleId, scheduleName, scheduleLocation, clubId, scheduleDate, scheduleTime);
        this.meetingType = meetingType;
    }

    public String getMeetingType() {
        return meetingType;
    }

    public void setMeetingType(String meetingType) {
        this.meetingType = meetingType;
    }
}
