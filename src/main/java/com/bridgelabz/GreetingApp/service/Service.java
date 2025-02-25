package com.bridgelabz.GreetingApp.service;

import com.bridgelabz.GreetingApp.model.Greeting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Service
public class Service {
    private final Map<Long, Greeting> messages = new HashMap<>();

    public boolean createMessage(Greeting myGreet) {
        messages.put(myGreet.getId(), myGreet);
        return true;
    }

    public Greeting getGreetingById(Long myId) {
        return messages.get(myId);
    }

    public List<Greeting> getAll(){
        return new ArrayList<>(messages.values());
    }


    public Greeting deleteGreetingById(Long myId) {
        return messages.remove(myId);
    }

    public Greeting updateGreetingById(Long id, Greeting msg) {
        return messages.put(id, msg);
    }
}
