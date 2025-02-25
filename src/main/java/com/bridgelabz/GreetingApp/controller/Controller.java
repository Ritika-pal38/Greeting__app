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
    public  String greeting(){
        return "Hello,from get method";
    }
    @GetMapping("/all")
    public List<Greeting> getAll(){
        return greetingService.getAll();
    }

    @PostMapping
    public boolean createMessage(@RequestBody Greeting myGreet) {
        return greetingService.createMessage(myGreet);
    }

    @GetMapping("/id/{myId}")
    public Greeting getGreetingById(@PathVariable Long myId) {
        return greetingService.getGreetingById(myId);
    }

    @DeleteMapping("/id/{myId}")
    public Greeting deleteGreetingById(@PathVariable Long myId) {
        return greetingService.deleteGreetingById(myId);
    }

    @PutMapping("/id/{myId}")
    public Greeting updateGreetingById(@PathVariable Long id, @RequestBody Greeting msg) {
        return greetingService.updateGreetingById(id, msg);
    }


}
