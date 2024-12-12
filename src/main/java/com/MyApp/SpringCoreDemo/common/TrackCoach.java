package com.MyApp.SpringCoreDemo.common;

import org.springframework.stereotype.Component;

// This marks the class as a Spring bean
@Component
public class TrackCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }
}
