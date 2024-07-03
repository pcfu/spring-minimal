package com.sephora.fuel.springminimal.exception;

public class RecordNotFoundException extends RuntimeException {

    private String entityName;
    private Long entityId;

    public RecordNotFoundException(String entityName, Long entityId) {
        this.entityName = entityName;
        this.entityId = entityId;
    }

    @Override
    public String getMessage() {
        return String.format("%s (ID: %d) not found", entityName, entityId);
    }
}
