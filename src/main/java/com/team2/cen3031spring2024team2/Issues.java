package com.team2.cen3031spring2024team2;

public class Issues {
    private String timestamp;
    private String description;
    private TicketStatus status;
    private String username;

    public Issues(){}

    public Issues(String timestamp, String description, TicketStatus status, String username) {
        this.timestamp = timestamp;
        this.description = description;
        this.status = status;
        this.username = username;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return timestamp + "," + description + "," + status.toString() + "," + username;
    }
}