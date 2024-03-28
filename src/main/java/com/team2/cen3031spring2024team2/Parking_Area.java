package com.team2.cen3031spring2024team2;

import java.time.LocalDate;
public class Parking_Area {

    private String map;

    private String area;

    private String description;

    private int areaCode;

    private Parking_Pass passType;

    public Parking_Area(String map, String area, String description, int areaCode) {
        this.map = map;
        this.area = area;
        this.description = description;
        this.areaCode = areaCode;
    }

    public String getMap() {
        return map;
    }

    public String getArea() {
        return area;
    }

    public String getDescription() {
        return description;
    }

    public int getAreaCode() {
        return areaCode;
    }

    public void setPass(String pass, double price, String description, LocalDate expirationDate) {
        passType = new Parking_Pass(pass, price, description, expirationDate);
    }

    public Parking_Pass getPass() {
        return passType;
    }
}
