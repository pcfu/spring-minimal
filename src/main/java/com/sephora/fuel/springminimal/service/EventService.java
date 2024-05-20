package com.sephora.fuel.springminimal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sephora.fuel.springminimal.repository.EventRepository;
import com.sephora.fuel.springminimal.document.Event;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public void addEvent(Event e) {
        eventRepository.save(e);
    }

    public long getCount() {
        return eventRepository.count();
    }
}
