package com.team2.cen3031spring2024team2;

import java.time.LocalDate;

public class Customer {

    Vehicle vehicle;

    private String name;

    private String password;

    private int id;

    private Parking_Pass pass;

    private double balance;

    public Customer(String name, String password, int id) {
        this.name = name;
        this.password = password;
        this.id = id;
    }

    public Customer(Vehicle vehicle, String name, String password, int id, Parking_Pass pass) {
        this.vehicle = vehicle;
        this.name = name;
        this.password = password;
        this.id = id;
        this.pass = pass;
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

    public Vehicle getVehicle() {
        return vehicle;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public Parking_Pass getPass() {
        return pass;
    }

    public double getBalance() {
        return balance;
    }
}