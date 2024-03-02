package com.team2.cen3031spring2024team2;

import java.time.LocalDate;

public class Parking_Pass {

    private String name;
    private double price;
    private String description;

    private LocalDate expirationDate;

    public Parking_Pass() {}

    public Parking_Pass(String name, double price, String description, LocalDate expirationDate) {

        this.name = name;
        this.price = price;
        this.description = description;
        this.expirationDate = expirationDate;
    }

    public Parking_Pass(String name, double price, String description) {

        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() { return name; }

    public double getPrice() { return price; }

    public String getDescription() { return description; }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

}