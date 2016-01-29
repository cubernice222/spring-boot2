package org.cuber.database.entity;

/**
 * Created by cuber on 2016/1/29.
 */

public class SingleMessage {
    private String id;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
