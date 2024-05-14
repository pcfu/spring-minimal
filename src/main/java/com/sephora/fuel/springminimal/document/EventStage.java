package com.sephora.fuel.springminimal.document;

public class EventStage {
    private String time;
    private String eventType;

    public EventStage(String time, String eventType) {
        this.time = time;
        this.eventType = eventType;
    }

    public String getTime() {
        return time;
    }

    public String getEventType() {
        return eventType;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }
}
