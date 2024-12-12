package com.MyApp.SpringCoreDemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// This marks the class as a Spring bean
@Component
// I recommended to use Qualifier
// bcs it's more specific and it has a higher priority
@Primary
public class BaseballCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes in batting practice";
    }
}
