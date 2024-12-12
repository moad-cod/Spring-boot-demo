package com.MyApp.SpringCoreDemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

// This marks the class as a Spring bean
@Component
public class TrackCoach implements Coach {

    public TrackCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName()); //Just the class name without the package structure
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }
}
