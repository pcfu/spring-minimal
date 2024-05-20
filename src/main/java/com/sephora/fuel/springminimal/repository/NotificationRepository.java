package com.sephora.fuel.springminimal.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.sephora.fuel.springminimal.document.Notification;

public interface NotificationRepository extends MongoRepository<Notification, String> {}
