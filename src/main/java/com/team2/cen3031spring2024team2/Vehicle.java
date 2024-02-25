package home;

public class Vehicle {

    private String make;
    private String model;
    private String color;
    private String licensePlate;

    public Vehicle(String make, String model, String color, String licensePlate) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.licensePlate = licensePlate;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public String getLicensePlate() {
        return licensePlate;
    }
}