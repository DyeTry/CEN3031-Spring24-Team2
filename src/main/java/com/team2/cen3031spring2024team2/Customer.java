package com.team2.cen3031spring2024team2;

import java.time.LocalDate;

public class Customer {

    Vehicle vehicle;

    private String name;

    private String username;

    private String password;

    private int id;

    private Parking_Pass pass;

    private int balance;

    public Customer(String name, String password, int id) {
        this.name = name;
        this.password = password;
        this.id = id;
    }

    public Customer( int id, String name, String password, Vehicle vehicle, Parking_Pass pass, int balance) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.vehicle = vehicle;
        this.pass = pass;
        this.balance = balance;
    }

    public void setVehicle(String make, String model, String color, String licensePlate) {
        this.vehicle = new Vehicle(make, model, color, licensePlate);
    }

    public void setPass(String name, double price, String description, LocalDate expirationDate) {
        this.pass = new Parking_Pass(name, price, description, expirationDate);
    }

    public void resetPass() {
        this.pass = new Parking_Pass();
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Parking_Pass getPass() {
        return pass;
    }

    public int getBalance() {
        return balance;
    }

    public String toString() {
        return getName() + "," + getPassword() + "," + getId() + "," + getVehicle() + "," + getPass() + "," + getBalance() + ",";
    }
}