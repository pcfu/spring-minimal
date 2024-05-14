package com.sephora.fuel.springminimal.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.sephora.fuel.springminimal.document.EventStage;
import java.util.List;

@Document(collection = "events")
public class Event {

    @Id
    private String id;

    private String source;
    private String country;
    private String name;

    private List<EventStage> stages;

    public Event(String source, String country, String name, List<EventStage> stages) {
        this.source = source;
        this.country = country;
        this.name = name;
        this.stages = stages;
    }

    public String getId() {
        return id;
    }
}
