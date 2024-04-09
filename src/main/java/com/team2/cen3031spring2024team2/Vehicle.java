package com.team2.cen3031spring2024team2;

public class Vehicle {

    //The Vehicle's make
    private String make;

    //The Vehicle's model
    private String model;

    //The Vehicle's color
    private String color;

    //The Vehicle's license plate
    private String licencePlate;

    //A default constructor for the Vehicle class
    public Vehicle() {}

    //A constructor for the Vehicle class
    public Vehicle(String make, String model, String color, String licencePlate) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.licencePlate = licencePlate;
    }

    //Returns the Vehicle's make
    public String getMake() {
        return make;
    }

    //Initializes the Vehicle's make
    public void setMake(String make) {
        this.make = make;
    }

    //Returns the Vehicle's model
    public String getModel() {
        return model;
    }

    //Initializes the Vehicle's model
    public void setModel(String model) {
        this.model = model;
    }

    //Returns the Vehicle's color
    public String getColor() {
        return color;
    }

    //Initializes the Vehicle's color
    public void setColor(String color) {
        this.color = color;
    }

    //Returns the Vehicle's license plate
    public String getLicencePlate() {
        return licencePlate;
    }

    //Initializes the Vehicle's license plate
    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public String toStringForCustomer() {
        return make + "," +
                model + "," +
                color + "," +
                licencePlate;
    }

    //Returns a formatted String
    @Override
    public String toString() {
        return make + "," +
                model + "," +
                color + "," +
                licencePlate + ",\n";
    }
}