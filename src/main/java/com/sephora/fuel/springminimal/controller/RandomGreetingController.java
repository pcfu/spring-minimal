package com.sephora.fuel.springminimal.controller;

import java.util.Random;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RandomGreetingController {

	@GetMapping(value={"/", "random_greeting"})
	public String greeting(@Value("#{new java.util.Random()}") Random r) {
        int rInt = r.nextInt();

        if (rInt % 4 == 0) {
    		return "Hello World!";
        } else if (rInt % 4 == 1) {
            return "Hey there!";
        } else if (rInt % 4 == 2) {
            return "Yo!";
        } else {
            return "How's it going?";
        }
	}
}
