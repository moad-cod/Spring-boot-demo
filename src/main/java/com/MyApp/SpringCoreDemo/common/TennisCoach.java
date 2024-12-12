package com.MyApp.SpringCoreDemo.common;

import org.springframework.stereotype.Component;

// This marks the class as a Spring bean
@Component
public class TennisCoach implements Coach {

    public TennisCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName()); //Just the class name without the package structure
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backand volley";
    }
}
