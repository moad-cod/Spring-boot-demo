package com.MyApp.SpringCoreDemo.common;

import org.springframework.stereotype.Component;

// This marks the class as a Spring bean
@Component
public class BaseballCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes in batting practice";
    }
}
