package com.team2.cen3031spring2024team2;

public class CustInfo {
    private String name;
    private String carMake;
    private String carModel;
    private String carColor;
    private String licensePlate;
    private String passExpirationDate;
    private String username;
    private String password;
    private String passType;
    private int employeeID;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getPassExpirationDate() {
        return passExpirationDate;
    }

    public void setPassExpirationDate(String passExpirationDate) {
        this.passExpirationDate = passExpirationDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getPassType() {
        return passType;
    }

    public void setPassType(String passType) {
        this.passType = passType;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                "\nCar Make: " + carMake +
                "\nCar Model: " + carModel +
                "\nCar Color: " + carColor +
                "\nLicense Plate: " + licensePlate +
                "\nPass Expiration Date: " + passExpirationDate +
                "\nPassType: " + passType +
                "\nUsername: " + username +
                "\nPassword: " + password +
                "\nEmployee ID: " + employeeID ;
    }
}
