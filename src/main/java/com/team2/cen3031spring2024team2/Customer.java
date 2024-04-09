package com.team2.cen3031spring2024team2;

public class Customer {

    //The Customer's first and last name
    private String name;

    //The Customer's username
    private String username;

    //The Customer's password
    private String password;

    //The Customer's id
    private int id;

    //The Customer's balance
    private int balance;

    //The Customer's Vehicle information
    private Vehicle vehicle;

    //The Customer's Parking Pass information
    private Parking_Pass parkingPass;

    //The Customer's Parking Fine information
    private Parking_Fine parkingFine;

    //The Customer's permit number
    private String permitNumber;

    //A default constructor for the Customer class
    public Customer() {}

    //A constructor for the Customer class
    public Customer(String name, String username, String password, int id, int balance, Vehicle vehicle) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.id = id;
        this.balance = balance;
        this.vehicle = vehicle;
    }

    //A constructor for the Customer class
    public Customer(String name, String username, String password, int id, int balance, Vehicle vehicle, Parking_Pass parkingPass, Parking_Fine parkingFine) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.id = id;
        this.balance = balance;
        this.vehicle = vehicle;
        this.parkingPass = parkingPass;
        this.parkingFine = parkingFine;
    }

    //Returns the Customer's name
    public String getName() {
        return name;
    }

    //Initializes the Customer's name
    public void setName(String name) {
        this.name = name;
    }

    //Returns the Customer's email
    public String getUsername() {
        return username;
    }

    //Initializes the Customer's email
    public void setUsername(String username) {
        this.username = username;
    }

    //Returns the Customer's password
    public String getPassword() {
        return password;
    }

    //Initializes the Customer's password
    public void setPassword(String password) {
        this.password = password;
    }

    //Returns the Customer's id
    public int getId() {
        return id;
    }

    //Initializes the Customer's id
    public void setId(int id) {
        this.id = id;
    }

    //Returns the Customer's account balance
    public int getBalance() {
        return balance;
    }

    //Initializes the Customer's balance
    public void setBalance(int balance) {
        this.balance = balance;
    }

    //Returns the Customer's vehicle information
    public Vehicle getVehicle() {
        return vehicle;
    }

    //Initializes the Customer's vehicle
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    //Returns the Customer's parking pass information
    public Parking_Pass getParkingPass() {
        return parkingPass;
    }

    //Initializes the Customer's parking pass
    public void setParkingPass(Parking_Pass parkingPass) {
        this.parkingPass = parkingPass;
    }

    //Returns the Customer's parking fine information
    public Parking_Fine getParkingFine() {
        return parkingFine;
    }

    //Initializes the Customer's parking fine
    public void setParkingFine(Parking_Fine parkingFine) {
        this.parkingFine = parkingFine;
    }

    //Returns the Customer's permit number
    public String getPermitNumber() {
        return permitNumber;
    }

    //Initializes the Customer's permit number
    public void setPermitNumber(String permitNumber) {
        this.permitNumber = permitNumber;
    }

    //Returns a formatted String
    @Override
    public String toString() {

        if (parkingPass == null) {
            return id + "," +
                    name + "," +
                    username + "," +
                    password + "," +
                    balance + "," +
                    vehicle.toStringForCustomer() + "," +
                    "null,null," +
                    permitNumber + ",\n";
        } else {
            return id + "," +
                    name + "," +
                    username + "," +
                    password + "," +
                    balance + "," +
                    vehicle.toStringForCustomer() + "," +
                    parkingPass.toStringForCustomer() + "," +
                    permitNumber + ",\n";
        }
    }
}
