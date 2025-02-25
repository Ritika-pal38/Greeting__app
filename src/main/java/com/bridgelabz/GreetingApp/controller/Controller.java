package com.bridgelabz.GreetingApp.controller;

import com.bridgelabz.GreetingApp.model.Greeting;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/greet")
public class Controller {
    private Map<Long, Greeting> messages = new HashMap<>();
    @GetMapping()
    public List<Greeting> getAll(){
        return new ArrayList<>(messages.values());
    }
    @PostMapping()
    public boolean createMessage(@RequestBody Greeting myGreet){
        messages.put(myGreet.getId(),myGreet);
        return  true;
    }
    @GetMapping("id/{myId}")
    public Greeting getGreetingById(@PathVariable Long myId){
        return messages.get(myId);
    }
    @DeleteMapping("id/{myId}")
    public Greeting deleteGreetingById(@PathVariable Long myId){
        return messages.remove(myId);
    }
    @PutMapping("id/{myId}")
    public Greeting updateGreetingById(@PathVariable Long id,@RequestBody Greeting msg){
         return messages.put(id,msg);
    }



}
