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
    public DemoController(Coach theCoach) { // First character lower-case
        myCoach = theCoach;
    } // Followed the primary class

    @GetMapping("/dailyworkout")
    String dailyWorkout() {
        return myCoach.getDailyWorkout();
    }


}
