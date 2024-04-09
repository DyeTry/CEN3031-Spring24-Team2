package com.team2.cen3031spring2024team2;

public class SubmittedIssues {

    //The Customer's username
    private String username;

    //The Submitted Issues description
    String issueDescription;

    //A default constructor for the Parking Pass class
    public SubmittedIssues() {}

    //Returns the Customer's username
    public String getUsername() {
        return username;
    }

    //Initializes the Customer's username
    public void setUsername(String username) {
        this.username = username;
    }

    //A default constructor for the Parking Pass class
    public SubmittedIssues(String username, String issueDescription) {
        this.username = username;
        this.issueDescription = issueDescription;
    }

    //Returns the Submitted Issues' Description
    public String getIssueDescription() {
        return issueDescription;
    }

    //Initializes the Submitted Issues' Description
    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    //Returns a formatted String
    @Override
    public String toString() {
        return username + "," + issueDescription + ",\n";
    }
}
