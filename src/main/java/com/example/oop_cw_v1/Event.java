package com.example.oop_cw_v1;

public class Event extends MainSchedule {
    private String eventType;

    public Event(String scheduleId, String scheduleName, String scheduleLocation, String clubId, String scheduleDate, String scheduleTime, String eventType) {
        super(scheduleId, scheduleName, scheduleLocation, clubId, scheduleDate, scheduleTime);
        this.eventType = eventType;
    }


    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }
}
