package com.bridgelabz.GreetingApp.controller;

import com.bridgelabz.GreetingApp.model.Greeting;
import com.bridgelabz.GreetingApp.service.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/greet")
public class Controller {
    private Map<Long, Greeting> messages = new HashMap<>();

    public final Service greetingService ;

    public Controller(Service greetingService) {
        this.greetingService = greetingService;
    }
    @GetMapping
    public String getGreeting(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {
        return greetingService.getGreeting(firstName, lastName);
    }


}
