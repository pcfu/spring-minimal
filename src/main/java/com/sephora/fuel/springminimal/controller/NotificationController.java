package com.sephora.fuel.springminimal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.sephora.fuel.springminimal.repository.NotificationRepository;
import com.sephora.fuel.springminimal.document.Notification;

import java.util.Map;
import java.util.HashMap;
import java.util.Optional;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationRepository repo;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Notification getNoti() {
        Optional<Notification> res = repo.findById("664a22389dc5a24bb3de6991");
        if (res.isPresent()) {
            return res.get();
        }

        return null;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addNoti() {
        Map<String, Object> m = new HashMap<>();
        m.put("country", "Singapore");
        m.put("street", "2 Springwood Close");
        m.put("postcode", 118077);

        Map<String, Double> coords = new HashMap<>();
        coords.put("latitude", 1.27936);
        coords.put("longitude", 103.79021);
        m.put("geolocation", coords);

        Notification n = new Notification("n1", m);
        repo.save(n);

        return n.getId();
    }

}
