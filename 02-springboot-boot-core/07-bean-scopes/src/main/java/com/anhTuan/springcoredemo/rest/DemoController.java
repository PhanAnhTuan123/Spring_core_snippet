package com.anhTuan.springcoredemo.rest;

import com.anhTuan.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // define a private field for the dependency

    private Coach myCoach;
    private Coach anotherCoach;

  @Autowired
  public void DemoController(
          @Qualifier("cricketCoach") Coach coach,
          @Qualifier("cricketCoach")Coach anotherCoach){


      System.out.println("In contructor: " + getClass().getSimpleName());

      this.myCoach = coach;
      this.anotherCoach = anotherCoach;
  }

    @GetMapping("/check")
    public String check(){
      return "Comparing beans: myCoach == anotherCoach, "+ (myCoach == anotherCoach);
    }


    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

}
