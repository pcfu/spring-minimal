package com.sephora.fuel.springminimal.document;

import java.util.Map;
import java.util.HashMap;
import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import com.mongodb.BasicDBObject;

@Document(collection = "notifications")
public class Notification implements Serializable {

    @Id
    private String id;

    private String name;

    @Field(value = "message_contents")
    private BasicDBObject messageContents;

    public Notification() {}

    public Notification(String name, Map contents) {
        this.name = name;
        if (contents == null) {
            contents = new HashMap();
        }
        this.messageContents = new BasicDBObject(contents);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Map getMessageContents() {
        if (messageContents != null) {
            return messageContents.toMap();
        }

        return null;
    }
}
