package com.team2.cen3031spring2024team2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CustomerInfo {
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
    private int balance;

    public CustomerInfo() {}
    public CustomerInfo(String name, String username, String password, String make, String model, String color, String licensePlate, int balance) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.carMake = make;
        this.carModel = model;
        this.carColor = color;
        this.licensePlate = licensePlate;
        this.balance = balance;
    }

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

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public boolean hasExpired() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        LocalDate formattedDate = LocalDate.parse(passExpirationDate, formatter);

        if (formattedDate.isAfter(currentDate)) {
            return true;
        } else {
            return false;
        }
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
                "\nEmployee ID: " + employeeID +
                "\nBalance: " + balance;
    }

    public String saveToFile() {
        return employeeID + "," +
                name + "," +
                carMake + "," +
                carModel + "," +
                carColor + "," +
                licensePlate + "," +
                passType + "," +
                passExpirationDate + "," +
                username + "," +
                password + "," +
                balance + ",\n";
    }
}
