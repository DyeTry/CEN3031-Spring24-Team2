package com.team2.cen3031spring2024team2;

public class Parking_Fine {

    //The Customer's username
    private String username;

    //The Parking Fine's number
    private String fineNumber;

    //The Parking Fine's date
    private String fineDate;

    //The Parking Fine's time
    private String fineTime;

    //The Parking Fine's amount
    private int fineAmount;

    //The Parking Fine's description
    private String fineDescription;

    //A default constructor for the Parking Fine class
    public Parking_Fine() {}

    //A constructor for the Parking Fine class
    public Parking_Fine(String fineNumber, String fineDate, String fineTime, int fineAmount, String fineDescription) {
        this.fineNumber = fineNumber;
        this.fineDate = fineDate;
        this.fineTime = fineTime;
        this.fineAmount = fineAmount;
        this.fineDescription = fineDescription;
    }

    //Returns the Customer's username
    public String getUsername() {
        return username;
    }

    //Initializes the Customer's username
    public void setUsername(String username) {
        this.username = username;
    }

    //Returns the Parking Fines number
    public String getFineNumber() {
        return fineNumber;
    }

    //Initializes the Parking Pass's number
    public void setFineNumber(String fineNumber) {
        this.fineNumber = fineNumber;
    }

    //Returns the Parking Fines date
    public String getFineDate() {
        return fineDate;
    }

    //Initializes the Parking Pass's date
    public void setFineDate(String fineDate) {
        this.fineDate = fineDate;
    }

    //Returns the Parking Fines time
    public String getFineTime() {
        return fineTime;
    }

    //Initializes the Parking Pass's time
    public void setFineTime(String fineTime) {
        this.fineTime = fineTime;
    }

    //Returns the Parking Fines amount
    public int getFineAmount() {
        return fineAmount;
    }

    //Initializes the Parking Pass's amount
    public void setFineAmount(int fineAmount) {
        this.fineAmount = fineAmount;
    }

    //Returns the Parking Fines description
    public String getFineDescription() {
        return fineDescription;
    }

    //Initializes the Parking Pass's description
    public void setFineDescription(String fineDescription) {
        this.fineDescription = fineDescription;
    }

    //Returns a formatted String
    @Override
    public String toString() {
        return username + "," +
                fineNumber + "," +
                fineDate + "," +
                fineTime + "," +
                fineAmount + "," +
                fineDescription + ",\n";
    }
}