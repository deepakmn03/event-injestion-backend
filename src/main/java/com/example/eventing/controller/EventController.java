package com.example.eventing.controller;

import com.example.eventing.dto.EventIngestRequest;
import com.example.eventing.model.EventEntity;
import com.example.eventing.repository.EventRepository;
import com.example.eventing.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RestController
public class EventController {

    @Autowired
    private EventService eventService;
    @Autowired
    private EventRepository eventRepository;

    @GetMapping("/events/{id}")
    public EventEntity getEventById(@PathVariable Long id){
        return eventService.getEventById(id);
    }

    @PostMapping("/events")
    public String injestEvent(@RequestBody EventIngestRequest request) {
        eventService.addEvent(request);
        return "Event added";
    }

    @GetMapping("/status")
    public String showStatus(){
        return "EventEntity Service is up and running!!";
    }
}
