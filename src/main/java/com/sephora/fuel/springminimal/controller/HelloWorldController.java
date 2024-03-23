package com.sephora.fuel.springminimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping(value={"/", "hello"})
	public String greeting() {
		return "Hello World!";
	}
}
