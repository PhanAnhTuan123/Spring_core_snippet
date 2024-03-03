package com.anhTuan.demo.rest;

public class StudentErrorResponse {
    private int stautus;
    private String message;
    private long timeStamp;
    public StudentErrorResponse(){

    }

    public StudentErrorResponse(int stautus, String message, long timeStamp) {
        this.stautus = stautus;
        this.message = message;
        this.timeStamp = timeStamp;
    }


    public int getStautus() {
        return stautus;
    }

    public void setStautus(int stautus) {
        this.stautus = stautus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
