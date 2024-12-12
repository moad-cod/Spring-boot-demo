package com.MyApp.SpringCoreDemo.common;

import org.springframework.stereotype.Component;

// This marks the class as a Spring bean
@Component
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName()); //Just the class name without the package structure
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes :Setter";
    }
}
