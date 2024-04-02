package com.team2.cen3031spring2024team2;

public class Vehicle {
    private String make;
    private String model;
    private String color;
    private String licensePlate;

    public Vehicle() {};

    public Vehicle(String make, String model, String color, String licensePlate) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.licensePlate = licensePlate;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}
