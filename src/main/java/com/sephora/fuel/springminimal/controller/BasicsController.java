package com.sephora.fuel.springminimal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class BasicsController {

	@GetMapping("dummy")
	public MyClass getDummyResponse() {
		return new MyClass("a value", "b value");
	}
}

class MyClass {
    private String a;
    private String b;
    private Object c;

    public MyClass(String a, String b) {
        this.a = a;
        this.b = b;
        c = null;
    }

    public String getAGetter() {
        return a;
    }

    public String getBGetter() {
        return b;
    }
}
