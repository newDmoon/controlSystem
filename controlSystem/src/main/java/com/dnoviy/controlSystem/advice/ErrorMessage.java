package com.dnoviy.controlSystem.advice;

import java.util.Date;
import java.util.List;

public class ErrorMessage {
    private int statusCode;
    private String statusName;
    private Date timestamp;
    private List<String> messages;
    private String description;

    public ErrorMessage() {
    }

    public ErrorMessage(int statusCode, String statusName, Date timestamp, List<String> messages, String description) {
        this.statusCode = statusCode;
        this.statusName = statusName;
        this.timestamp = timestamp;
        this.messages = messages;
        this.description = description;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
