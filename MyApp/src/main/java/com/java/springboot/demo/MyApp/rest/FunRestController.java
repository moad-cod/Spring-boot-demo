package com.java.springboot.demo.MyApp.rest;

<<<<<<< HEAD
=======
import org.springframework.beans.factory.annotation.Value;
>>>>>>> 44ec937 (InjectingPropreties)
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
<<<<<<< HEAD
=======

    // Inject properties for: coach.name and team.name
    @Value("${coach.name}")
    private  String coachName;

    @Value("${team.name}")
    private  String teamhName;

    // Expose new endpoint for "teaminfo"

    @GetMapping("/teaminfo")
    public String teaminfo() {
        return "Coach: "+coachName + ", Team name: " + teamhName;
    }

>>>>>>> 44ec937 (InjectingPropreties)
    // expose "/" that return "Hello World"

    @GetMapping("/") //Hundl HTTP GET Requests
    public String sayHello() {
        return "Hello World";
    }

    // expose a new endpoint for "workout"

    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run a hard 5k!";
    }

    // expose a new endpoint for "fortune"

    @GetMapping("/fortune")
    public String getDailyFortune() {
        return "Today is your lucky day.";
    }

}
