package com.MyApp.SpringCoreDemo.common;

import org.springframework.stereotype.Component;

// This marks the class as a Spring bean
@Component
public class TennisCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Practice your backand volley";
    }
}
