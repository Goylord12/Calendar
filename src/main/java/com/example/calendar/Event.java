package com.example.calendar;

import java.sql.Date;

public class Event {
    private Date date;
    private String event, time;

    public Event(Date date, String time, String event){

        this.date = date;
        this.time = time;
        this.event = event;
    }

    public Event( String time, String event){
        this.time = time;
        this.event = event;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
