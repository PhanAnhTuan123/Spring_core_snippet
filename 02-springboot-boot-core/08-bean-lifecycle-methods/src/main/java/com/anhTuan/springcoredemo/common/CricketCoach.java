package com.anhTuan.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {


    // define our init method
    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("In doMyStartStuff(): "+getClass().getSimpleName());
    }


    //define our destroy method
    @PreDestroy
    public void doMyCleanupStuff(){
        System.out.println("In doMyCleanStuff(): "+getClass().getSimpleName());
    }

    public CricketCoach(){
        System.out.println("In contructor: "+getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes@@";
    }
}
