package com.MyApp.SpringCoreDemo.rest;

import com.MyApp.SpringCoreDemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;
    @Autowired
    public DemoController(
            // Default scope is singleton
            //@Qualifier("swimCoach") Coach theCoach // You can do this
            @Qualifier("aquatic") Coach theCoach // Or this
    )
    { // First character lower-case
        System.out.println("In constructor: " + getClass().getSimpleName());
        myCoach = theCoach;
    } // Followed the primary class

    @GetMapping("/dailyworkout")
    public String dailyWorkout() {
        return myCoach.getDailyWorkout();
    }

}
