package com.team2.cen3031spring2024team2;

public class Parking_Pass {

    //The Customer's username
    private String username;

    //The Parking Pass type
    private String passType;

    //The Parking Pass price
    private int passPrice;

    //The Parking Pass description
    private String passDescription;

    //The Parking Pass expiration date
    private String passExpirationDate;

    //A default constructor for the Parking Pass class
    public Parking_Pass() {}

    //A constructor for Parking Pass info for the Customer
    public Parking_Pass(String passType, String passExpirationDate) {
        this.passType = passType;
        this.passExpirationDate = passExpirationDate;
    }

    //A constructor for the Parking Pass class
    public Parking_Pass(String passType, int passPrice, String passDescription, String passExpirationDate) {
        this.passType = passType;
        this.passPrice = passPrice;
        this.passDescription = passDescription;
        this.passExpirationDate = passExpirationDate;
    }

    //Returns the Customer's username
    public String getUsername() {
        return username;
    }

    //Initializes the Customer's username
    public void setUsername(String username) {
        this.username = username;
    }

    //Returns the Parking Pass's type
    public String getPassType() {
        return passType;
    }

    //Initializes the Parking Pass's type
    public void setPassType(String passType) {
        this.passType = passType;
    }

    //Returns the Parking Pass's price
    public int getPassPrice() {
        return passPrice;
    }

    //Initializes the Parking Pass's price
    public void setPassPrice(int passPrice) {
        this.passPrice = passPrice;
    }

    //Returns the Parking Pass's description
    public String getPassDescription() {
        return passDescription;
    }

    //Initializes the Parking Pass's description
    public void setPassDescription(String passDescription) {
        this.passDescription = passDescription;
    }

    //Returns the Parking Pass's expiration date
    public String getPassExpirationDate() {
        return passExpirationDate;
    }

    //Initializes the Parking Pass's expiration date
    public void setPassExpirationDate(String passExpirationDate) {
        this.passExpirationDate = passExpirationDate;
    }

    //A method to check if the Customer's parking pass has expired
    public boolean hasExpired() {
        return false;
    }

    public String toStringForCustomer() {
        return passType + "," +
                passExpirationDate;
    }

    //Returns a formatted String
    @Override
    public String toString() {
        return passType + "," +
                passPrice + "," +
                passDescription + "," +
                passExpirationDate + ",\n";
    }
}