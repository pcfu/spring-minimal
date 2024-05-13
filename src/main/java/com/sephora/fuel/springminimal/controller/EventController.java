package com.sephora.fuel.springminimal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.sephora.fuel.springminimal.service.EventService;
import com.sephora.fuel.springminimal.document.Event;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public long getCount() {
        long count = eventService.getCount();
        System.out.printf("===== Found %d events =====%n", count);
        return count;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addUser() {
        Event e = new Event("Demo", "SG", "test event");
        eventService.addEvent(e);
        return e.getId();
    }

    // @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    // public User getUser(@PathVariable("id") long id) {
    //     return userService.getUser(id);
    // }

    // @PostMapping(value = "/add")
    // public User addUser(@RequestBody User user){
    //     return userService.addUser(user);
    // }

    // @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    // public User deleteUser(@PathVariable("id") long id) {
    //     return userService.deleteUser(id);
    // }

}
