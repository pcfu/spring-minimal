package com.sephora.fuel.springminimal.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.sephora.fuel.springminimal.document.Event;

public interface EventRepository extends MongoRepository<Event, String> {}
