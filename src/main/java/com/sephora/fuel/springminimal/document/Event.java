package com.sephora.fuel.springminimal.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "events")
public class Event {

    @Id
    private String id;

    private String source;
    private String country;
    private String name;

    public Event(String source, String country, String name) {
        this.source = source;
        this.country = country;
        this.name = name;
    }

    public String getId() {
        return id;
    }
}
