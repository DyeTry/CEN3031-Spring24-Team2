package com.team2.cen3031spring2024team2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Parking_Manager {

    private ArrayList<Customer> customerList = new ArrayList<Customer>();
    private ArrayList<Employee> employeeList = new ArrayList<Employee>();
    private ArrayList<Parking_Fines> finesList = new ArrayList<Parking_Fines>();
    private ArrayList<Parking_Pass> passList = new ArrayList<Parking_Pass>();
    private ArrayList<Parking_Area> areaList = new ArrayList<Parking_Area>();

    public Parking_Manager() {

        loadCustomerDatabase();
        loadEmployeeDatabase();
        loadParkingPass();
    }

    private void createCustomerAccount(String name, String passwordString) {
        customerList.add(new Customer(name, passwordString, 1000 + customerList.size()));
    }

    private void createEmployeeAccount(String name, String passwordString) {
        employeeList.add(new Employee(name, passwordString, 1000 + employeeList.size()));
    }

    /**
     * PENDING TESTING
     *
     * A method to register Vehicle objects to Customers
     *
     * @param id The Customer's ID
     * @param make The make of the vehicle
     * @param model The model of the vehicle
     * @param color The color of the vehicle
     * @param licensePlate The license plate of the vehicle
     */
    public void registerVehicle(int id, String make, String model, String color, String licensePlate) {

        Customer customer = findCustomer(id);
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
     * @param id The Customer's ID
     * @param name The Parking Pass' name
     */
    public void buyParkingPass(int id, String name) {

        Customer customer = findCustomer(id);

        for (Parking_Pass pass : passList) {

            if (name.equals(pass.getName())) {
                customer.setPass(pass.getName(), pass.getPrice(), pass.getDescription(), LocalDate.now().plusYears(1));
            }
        }
    }

    /**
     * PENDING TESTING
     *
     * A method to update the Customer's Parking Pass
     *
     * @param id The Customer's ID
     * @param name The Parking Pass' name
     */
    public void updateParkingPass(int id, String name) {

        Customer customer = findCustomer(id);

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
     * @param id The Customer's ID
     */
    public void renewParkingPass(int id) {

        Customer customer = findCustomer(id);

        if (customer.getBalance() >= customer.getPass().getPrice()) {
            customer.getPass().getExpirationDate().plusYears(1);
        }
    }

    /**
     * PENDING TESTING
     * A method that cancels the Customer's parking pass
     *
     * @param id The Customer's ID
     */
    public void cancelParkingPass(int id) {

        Customer customer = findCustomer(id);
        customer.resetPass();
    }

    public void save() {
        /**
         * Implement a method to save data to the desired databases
         */
    }

    /**
     * PENDING TESTING
     *
     * A method to find Customer info based on their ID
     *
     * @param id The Customer's ID
     * @return Returns Customer info
     */
    private Customer findCustomer(int id) {

        for (Customer info : customerList) {

            if (info.getId() == id) {
                return info;
            }
        }

        return null;
    }

    /**
     * A method to read Parking Pass information in data.csv
     */
    private void loadParkingPass() {

        String path = "src\\main\\java\\home\\csv files\\pass.csv";
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

        String path = "src\\main\\java\\home\\csv files\\customer.csv";
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

        String path = "src\\main\\java\\home\\csv files\\employee.csv";
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
}