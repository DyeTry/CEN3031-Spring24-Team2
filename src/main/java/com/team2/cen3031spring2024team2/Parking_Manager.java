package com.team2.cen3031spring2024team2;

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

    private final ArrayList<Customer> customerList = new ArrayList<>();
    private final ArrayList<Employee> employeeList = new ArrayList<>();
    private final ArrayList<User> userList = new ArrayList<>();
    private final ArrayList<Parking_Fines> finesList = new ArrayList<>();
    private final ArrayList<Parking_Pass> passList = new ArrayList<>();
    private final ArrayList<Parking_Area> areaList = new ArrayList<>();

    public Parking_Manager() {
        //loadCustomerDatabase();
        //loadEmployeeDatabase();
        loadUserDatabase();
        loadParkingPass();
    }

    private void createCustomerAccount(String name, String passwordString) {
        customerList.add(new Customer(name, passwordString, 1000 + customerList.size()));
    }

    private void createEmployeeAccount(String name, String passwordString) {
        employeeList.add(new Employee(name, passwordString, 1000 + employeeList.size()));
    }

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

        Customer customer = findCustomer(username);
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

        Customer customer = findCustomer(username);

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

        Customer customer = findCustomer(username);

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

        Customer customer = findCustomer(username);
        customer.resetPass();
    }

    /**
     * PENDING TESTING
     *
     * A public method to save informtion to the desired databases
     */
    public void save() {

        saveCustomerDatabase();
        saveEmployeeDatabase();
    }

    /**
     * PENDING TESTING
     *
     * A method to find Customer info based on their username
     *
     * @param username The Customer's username
     * @return Returns Customer info
     */
    private Customer findCustomer(String username) {

        for (Customer info : customerList) {

            if (Objects.equals(info.getUsername(), username)) {
                System.out.println(info.getName());
                return info;
            }
        }

        return null;
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
     * A method to load Customer data
     */
    private void loadCustomerDatabase() {

        String path = "src\\main\\resources\\com\\team2\\cen3031spring2024team2\\csv files\\customer.csv";
        FileInputStream fileByteStream = null;
        Scanner inFS = null;

        try {
            System.out.println("Loading Customer info...");
            fileByteStream = new FileInputStream(path);
            inFS = new Scanner(fileByteStream);
        }

        catch (FileNotFoundException exception) {
            System.out.println(exception.toString());
        }

        inFS.useDelimiter(",");

        while (inFS.hasNext()) {

            String name = inFS.next();
            String password = inFS.next();

            createCustomerAccount(name, password);
        }

        try {
            System.out.println("Successfully read Customer info.");
            fileByteStream.close();
        }

        catch (IOException exception) {
            System.out.println(exception.toString());
        }
    }

    /**
     * A method to load Employee data
     */
    private void loadEmployeeDatabase() {

        String path = "src\\main\\resources\\com\\team2\\cen3031spring2024team2\\csv files\\employee.csv";
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

            String name = inFS.next();
            String password = inFS.next();

            createEmployeeAccount(name, password);
        }

        try {
            System.out.println("Successfully read Employee info.");
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
            System.out.println("id = " + id);

            String name = inFS.next();
            System.out.println("name = " + name);

            String make = inFS.next();
            System.out.println("make = " + make);

            String model = inFS.next();
            System.out.println("model = " + model);

            String color = inFS.next();
            System.out.println("color = " + color);

            String licensePlate = inFS.next();
            System.out.println("LP = " + licensePlate);

            String passType = inFS.next();
            System.out.println("pass type = " + passType);

            String passExpirationDate = inFS.next();
            System.out.println("date = " + passExpirationDate);

            int balance = inFS.nextInt();
            System.out.println("balance = " + balance);

            String username = inFS.next();
            System.out.println("username = " + username);

            String password = inFS.next();
            System.out.println("password" + password);

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
     * PENDING TESTING
     *
     * A method to save and append Customer information to the Customer database
     */
    private void saveCustomerDatabase() {

        String path = "src\\main\\java\\home\\csv files\\customer.csv";
        FileOutputStream fileStream = null;
        PrintWriter outFS = null;

        try {
            fileStream = new FileOutputStream(path, true);
            outFS = new PrintWriter(fileStream);
        }

        catch (FileNotFoundException exception) {
            System.out.println(exception.toString());
        }

        for (Customer info : customerList) {
            outFS.println(info.toString());
        }

        outFS.close();
    }

    /**PENDING TESTING
     *
     * A method to save and append Employee information to the Employee database
     */
    private void saveEmployeeDatabase() {

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

        for (Employee info : employeeList) {
            outFS.println(info.toString());
        }

        outFS.close();
    }
}