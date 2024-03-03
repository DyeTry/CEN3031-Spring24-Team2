package com.team2.cen3031spring2024team2;

import depreciated_files.Customer;
import depreciated_files.Employee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Parking_Manager {
    private final ArrayList<User> userList = new ArrayList<>();
    private final ArrayList<Parking_Fines> finesList = new ArrayList<>();
    private final ArrayList<Parking_Pass> passList = new ArrayList<>();
    private final ArrayList<Parking_Area> areaList = new ArrayList<>();

    public Parking_Manager() {
        loadUserDatabase();
        loadParkingPass();
    }

    /**
     * A method to create a User account with the ArrayList
     * @param id
     * @param name
     * @param make
     * @param model
     * @param color
     * @param licensePlate
     * @param passType
     * @param passExpirationData
     * @param balance
     * @param username
     * @param password
     */
    private void createUserAccount(int id, String name, String make, String model, String color, String licensePlate, String passType, String passExpirationData, int balance, String username, String password) {
        userList.add(new User(id, name, username, password,  new Vehicle(make, model, color, licensePlate), new Parking_Pass(), balance));
    }

    /**
     * PENDING TESTING
     *
     * A method to register Vehicle objects to Customers
     *
     * @param username The Customer's username
     * @param make The make of the vehicle
     * @param model The model of the vehicle
     * @param color The color of the vehicle
     * @param licensePlate The license plate of the vehicle
     */
    public void registerVehicle(String username, String make, String model, String color, String licensePlate) {

        User customer = findUser(username);
        customer.setVehicle(make, model, color, licensePlate);
    }

    public void updateVehicle(String make, String model, String color, String licensePlate) {
        /**
         * Implement a way to update vehicle information
         * Might just use registerVehicle() again
         */
    }

    /**
     * PENDING TESTING
     *
     * A method to buy a Parking Pass for Customers
     *
     * @param username The Customer's username
     * @param name The Parking Pass' name
     */
    public void buyParkingPass(String username, String name) {

        User user = findUser(username);

        for (Parking_Pass pass : passList) {

            if (name.equals(pass.getName())) {

                try {
                    user.setPass(pass.getName(), pass.getPrice(), pass.getDescription(), LocalDate.now().plusYears(1));
                    System.out.println("Successfully Set Pass");
                }

                catch (NullPointerException exception) {
                    System.out.println(exception.toString());
                }
            }
        }
    }

    /**
     * PENDING TESTING
     *
     * A method to update the Customer's Parking Pass
     *
     * @param username The Customer's username
     * @param name The Parking Pass' name
     */
    public void updateParkingPass(String username, String name) {

        User customer = findUser(username);

        if (customer.getPass() != null) {

            for (Parking_Pass pass : passList) {

                if (name.equals(pass.getName())) {
                    customer.setPass(pass.getName(), pass.getPrice(), pass.getDescription(), LocalDate.now().plusYears(1));
                }
            }
        }
    }

    /**
     * PENDING TESTING
     *
     * A method to renew the Customer's parking pass
     *
     * @param username The Customer's username
     */
    public void renewParkingPass(String username) {

        User customer = findUser(username);

        if (customer.getBalance() >= customer.getPass().getPrice()) {
            customer.getPass().getExpirationDate().plusYears(1);
        }
    }

    /**
     * PENDING TESTING
     * A method that cancels the Customer's parking pass
     *
     * @param username The Customer's username
     */
    public void cancelParkingPass(String username) {
        /**
         * Implement a way to cancel User parking pass
         */
    }

    /**
     * PENDING TESTING
     *
     * A public method to save informtion to the desired databases
     */
    public void save() {
        saveUserDatabase();
    }

    /**
     * A method to find User info based on their username
     *
     * @param username The User's username
     * @return Returns User info
     */
    private User findUser(String username) {

        for (User info : userList) {

            //System.out.println("Username  = " + info.getUsername());

            if (Objects.equals(info.getUsername(), username)) {

                //System.out.println("Name = " + info.getName());

                return info;
            }
        }

        return null;
    }

    /**
     * A method to read Parking Pass information in data.csv
     */
    private void loadParkingPass() {

        String path = "src\\main\\resources\\com\\team2\\cen3031spring2024team2\\csv files\\pass.csv";
        FileInputStream fileByteStream = null;
        Scanner inFS = null;

        try {
            System.out.println("Reading Parking Pass info...");
            fileByteStream = new FileInputStream(path);
            inFS = new Scanner(fileByteStream);
        }

        catch (FileNotFoundException exception) {
            System.out.println(exception.toString());
        }

        inFS.useDelimiter(",");

        while(inFS.hasNext()) {

            String name = inFS.next();
            double price = inFS.nextDouble();
            String description = inFS.next();

            passList.add(new Parking_Pass(name, price, description));
        }

        try {
            System.out.println("Successfully read Parking Pass info.");
            fileByteStream.close();
        }

        catch (IOException exception) {
            System.out.println(exception.toString());
        }
    }

    /**
     * A method to load All User data
     */
    private void loadUserDatabase() {

        String path = "src\\main\\resources\\com\\team2\\cen3031spring2024team2\\csv files\\user.csv";
        FileInputStream fileByteStream = null;
        Scanner inFS = null;

        try {
            System.out.println("Reading Employee info...");
            fileByteStream = new FileInputStream(path);
            inFS = new Scanner(fileByteStream);
        }

        catch (FileNotFoundException exception) {
            System.out.println(exception.toString());
        }

        inFS.useDelimiter(",");

        while (inFS.hasNext()) {

            int id = inFS.nextInt();
            System.out.println(id);

            String name = inFS.next();
            System.out.println(name);

            String make = inFS.next();
            System.out.println(make);

            String model = inFS.next();
            System.out.println(model);

            String color = inFS.next();
            System.out.println(color);

            String licensePlate = inFS.next();
            System.out.println(licensePlate);

            String passType = inFS.next();
            System.out.println(passType);

            String passExpirationDate = inFS.next();
            System.out.println(passExpirationDate);

            int balance = inFS.nextInt();
            System.out.println(balance);

            String username = inFS.next();
            System.out.println(username);

            String password = inFS.next();
            System.out.println(password);

            createUserAccount(id, name, make, model, color, licensePlate, passType, passExpirationDate, balance, username, password);

            inFS.nextLine();
        }

        try {
            System.out.println("Successfully read User info.");
            fileByteStream.close();
        }

        catch (IOException exception) {
            System.out.println(exception.toString());
        }
    }

    /**
     * A method to save User information to the database
     */
    private void saveUserDatabase() {

        String path = "src\\main\\java\\home\\csv files\\employee.csv";
        FileOutputStream fileStream = null;
        PrintWriter outFS = null;

        try {
            fileStream = new FileOutputStream(path, true);
            outFS = new PrintWriter(fileStream);
        }

        catch (FileNotFoundException exception) {
            System.out.println(exception.toString());
        }

        for (User info : userList) {
            outFS.println(info.toString());
        }

        outFS.close();
    }
}