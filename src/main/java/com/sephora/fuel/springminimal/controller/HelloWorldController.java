package com.sephora.fuel.springminimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping(value={"/", "hello"})
	public String greeting() {
        System.out.println("testing code climate integration");

		return "Hello World!";
	}
}
