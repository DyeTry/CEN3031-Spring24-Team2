package com.team2.cen3031spring2024team2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Database {

    //A list of all Employees
    private List<Customer> employeeList = new ArrayList<>();

    //A list of all Customers
    private List<Customer> customerList = new ArrayList<>();

    //A list of all Fines
    private List<Parking_Fine> fineList = new ArrayList<>();

    //A list of all Issues
    private List<SubmittedIssues> issuesList = new ArrayList<>();

    //A default constructor for the Database class
    public Database() {}

    //Returns the Employee List
    public List<Customer> getEmployeeList() {
        return employeeList;
    }

    //Initializes the Employee List
    public void setEmployeeList(List<Customer> employeeList) {
        this.employeeList = employeeList;
    }

    //Returns the Customer List
    public List<Customer> getCustomerList() {
        return customerList;
    }

    //Initializes the Customer List
    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    //Returns the Fine List
    public List<Parking_Fine> getFineList() {
        return fineList;
    }

    //Initializes the Fine List
    public void setFineList(List<Parking_Fine> fineList) {
        this.fineList = fineList;
    }

    //Returns the Issue List
    public List<SubmittedIssues> getIssuesList() {
        return issuesList;
    }

    //Initializes the Issues List
    public void setIssuesList(List<SubmittedIssues> issuesList) {
        this.issuesList = issuesList;
    }

    //A method to add a Customer to the arraylist
    public void addCustomerProfile(String name, String username, String password, String make, String model, String color, String licensePlate, int balance) {
        customerList.add(new Customer(name, username, password, 0, balance, new Vehicle(make, model, color, licensePlate)));
    }

    //A method to add a Fine to the arraylist
    public void addFineInformation(String citationNumber, String date, String time, String permitNumber, String username, int fineAmount, String reasonForFine) {
        //fines.add(new Parking_Fine(citationNumber, date, time, permitNumber, username, fineAmount, reasonForFine));
    }

    //A method to add an Issue Ticket to the arraylist
    public void addCustomerIssue(String username, String submittedIssue) {
        issuesList.add(new SubmittedIssues(username, submittedIssue));
    }

    //A method to find the Customer given a username
    public Customer getUser(String username) {
        for(Customer c : customerList) {
            if(c.getUsername().equals(username))
                return c;
        }
        for(Customer c : employeeList) {
            if(c.getUsername().equals(username))
                return c;
        }
        return null;
    }

    //Inaccurate count for fines
    public int getFineCount(String username) {
        int tempIndex = 0;
        for (Parking_Fine info : fineList) {
            //System.out.println(info.getUsername() + " == " + username);
            if (info.getUsername().equals(username)) {
                tempIndex++;
            }
        }
        return tempIndex;
    }

    //A method to read Customer/Employee information
    public void loadUserDatabase(String filename) {

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean firstLine = true;  // Flag to skip the first line

            while ((line = br.readLine()) != null) {

                if (firstLine && !(firstLine = false)) continue; // Skip the first line

                String[] data = line.split(",");
                if (data.length == 12) {
                    Customer info = new Customer();

                    info.setName(data[1].trim());
                    info.setUsername(data[2].trim());
                    info.setPassword(data[3].trim());
                    info.setBalance((Integer.parseInt(data[4].trim())));

                    info.setVehicle(new Vehicle(data[5].trim(), data[6].trim(), data[7].trim(), data[8].trim()));

                    info.setParkingPass(new Parking_Pass(data[9].trim(), data[10].trim()));

                    info.setPermitNumber(data[11].trim());

                    int employeeID = 0;

                    try {
                        employeeID = Integer.parseInt(data[0].trim());
                    } catch (NumberFormatException e) {
                        // If it's not a valid employee ID, it will remain 0
                    }

                    if (employeeID != 0) {
                        info.setId(employeeID);
                        employeeList.add(info);
                        System.out.println("Added Employee"); //TESTING METHOD
                    } else {
                        customerList.add(info);
                        System.out.println("Added Customer"); //TESTING METHOD
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //A method to read Fine information
    public void loadFineDatabase(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean firstLine = true;  // Flag to skip the first line

            while ((line = br.readLine()) != null) {

                if (firstLine && !(firstLine = false)) continue; // Skip the first line

                String[] data = line.split(",");
                if (data.length == 6) {
                    Parking_Fine parking_fine = new Parking_Fine();

                    parking_fine.setUsername(data[0].trim());
                    parking_fine.setFineNumber(data[1].trim());
                    parking_fine.setFineDate(data[2].trim());
                    parking_fine.setFineTime(data[3].trim());
                    parking_fine.setFineAmount(Integer.parseInt(data[4].trim()));
                    parking_fine.setFineDescription(data[5].trim());

                    fineList.add(parking_fine);
                    System.out.println("Added Fine"); //TESTING METHOD
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadIssueDatabase(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean firstLine = true;  // Flag to skip the first line

            while ((line = br.readLine()) != null) {

                if (firstLine && !(firstLine = false)) continue; // Skip the first line

                String[] data = line.split(",");
                if (data.length == 2) {
                    SubmittedIssues info = new SubmittedIssues();

                    info.setUsername(data[0].trim());
                    info.setIssueDescription(data[1].trim());

                    issuesList.add(info);
                    System.out.println("Support Ticket Added."); //TESTING METHOD
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //A method to save Customer/Employee information
    public void saveDatabase() {

        File newFile = new File("src\\main\\resources\\com\\team2\\cen3031spring2024team2\\csv_files\\User_Database.csv");
        FileWriter saveToDatabase = null;

        try {
            //Initizes the file
            saveToDatabase = new FileWriter(newFile);

            //Writes the first line
            saveToDatabase.write("ID,Name,Username,Password,Balance,Make,Model,Color,License Plate,Pass Type,Expiration Date,Permit Number,\n");

            //Writes the Employee Information
            for (int i = 0; i < employeeList.size(); i++) {
                saveToDatabase.write(employeeList.get(i).toString());
            }

            //Writes the Customer Information
            for (int i = 0; i < customerList.size(); i++) {
                saveToDatabase.write(customerList.get(i).toString());
            }

            saveToDatabase.close();

            //Catches an IO exception
        } catch (IOException e) {
            System.out.println(e.toString());
        }

        System.out.println("Saved to Database");
    }

    //A method to save Fine information
    public void saveFines() {
        File newFile = new File("src\\main\\resources\\com\\team2\\cen3031spring2024team2\\csv_files\\Fines_Database.csv");
        FileWriter saveToDatabase = null;

        try {
            //Initizes the file
            saveToDatabase = new FileWriter(newFile);

            //Writes the first line
            saveToDatabase.write("Username,Citation number,Date,Time,Fine amount,Reason for fine,\n");

            //Writes the Fine Information
            for (int i = 0; i < fineList.size(); i++) {
                saveToDatabase.write(fineList.get(i).toString());
            }

            saveToDatabase.close();

            //Catches an IO exception
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    //A method to save Issue Ticket information
    public void saveIssues() {
        File newFile = new File("src\\main\\resources\\com\\team2\\cen3031spring2024team2\\csv_files\\Issues_Database.csv");
        FileWriter saveToDatabase = null;

        try {
            //Initizes the file
            saveToDatabase = new FileWriter(newFile);

            //Writes the first line
            saveToDatabase.write("Username,Description,\n");

            //Writes the Fine Information
            for (int i = 0; i < issuesList.size(); i++) {
                saveToDatabase.write(issuesList.get(i).toString() + ",\n");
            }

            saveToDatabase.close();

            //Catches an IO exception
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    //A method to generate a random string of n size
    public String randomStringGenerator(int size) {

        // choose a Character random from this String
        String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(size);

        for (int i = 0; i < size; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index = (int)(alphaNumericString.length() * Math.random());

            // add Character one by one in end of sb
            sb.append(alphaNumericString.charAt(index));
        }
        return sb.toString();
    }
}