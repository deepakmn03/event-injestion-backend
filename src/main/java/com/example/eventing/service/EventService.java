package com.example.eventing.service;

import com.example.eventing.dto.EventIngestRequest;
import com.example.eventing.model.EventEntity;
import com.example.eventing.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventService {

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private LocalContainerEntityManagerFactoryBean entityManagerFactory2;

    //get event by id
    public EventEntity getEventById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));
    }

    public void addEvent(EventIngestRequest request){
        EventEntity event = new EventEntity();
        event.setEventType(request.getEventType());
        event.setSource(request.getSource());
        event.setPayload(request.getPayload());
        eventRepository.save(event);
    }
}
