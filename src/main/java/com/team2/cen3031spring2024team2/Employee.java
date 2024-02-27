package com.team2.cen3031spring2024team2;

public class Employee {

    private String name;
    private String password;
    private int id;
    Vehicle vehicle;
    private Parking_Pass pass;

    private double balance;

    public Employee(String name, String password, int id) {
        this.name = name;
        this.password = password;
        this.id = id;
    }

    public Employee(String name, String password, int id, Vehicle vehicle, Parking_Pass pass) {
        this.name = name;
        this.password = password;
        this.id = id;
        this.vehicle = vehicle;
        this.pass = pass;
    }

    public void setVehicle(String make, String model, String color, String licensePlate) {
        this.vehicle = new Vehicle(make, model, color, licensePlate);
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

    public String toString() {
        return getName() + "," + getPassword() + "," + getId() + "," + getVehicle() + "," + getPass() + "," + getBalance() + ",";
    }
}