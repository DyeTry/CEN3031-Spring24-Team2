package com.team2.cen3031spring2024team2;

import java.io.*;
import java.text.spi.DateFormatProvider;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<CustomerInfo> employeeInfos = new ArrayList<>();
    private List<CustomerInfo> customerInfos = new ArrayList<>();
    private List<Issues> issuesList = new ArrayList<>();
    private List<Parking_Fine> fines = new ArrayList<>();
    private String file;
    public int userCount = 0;

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public List<CustomerInfo> getEmployeeInfos() {
        return employeeInfos;
    }

    public List<CustomerInfo> getCustomerInfos() {
        return customerInfos;
    }

    public List<Parking_Fine> getFines() {
        return fines;
    }

    public List<Issues>  getIssuesList() {return issuesList;}

    public CustomerInfo getUser(String username) {
        for(CustomerInfo c : customerInfos) {
            if(c.getUsername().equals(username))
                return c;
        }
        for(CustomerInfo c : employeeInfos) {
            if(c.getUsername().equals(username))
                return c;
        }
        return null;
    }

    //Inaccurate count for fines
    public int getFineCount(String username) {
        int tempIndex = 0;
        for (Parking_Fine info : fines) {
            //System.out.println(info.getUsername() + " == " + username);
            if (info.getUsername().equals(username)) {
                tempIndex++;
            }
        }
        return tempIndex;
    }

    public void createCustomerProfile(String name, String username, String password, String make, String model, String color, String licensePlate, int balance) {
        customerInfos.add(new CustomerInfo(name, username, password, make, model, color, licensePlate, balance));
    }

    public void addFineInformation(String citationNumber, String date, String time, String username, int fineAmount, String reasonForFine, String paymentStatus) {
        fines.add(new Parking_Fine(citationNumber, date, time, username, fineAmount, reasonForFine, paymentStatus));
    }

    public void loadDatabaseFromCSV(String filename) {
        setFile(filename);

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean firstLine = true;  // Flag to skip the first line
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;  // Skip the first line
                }
                String[] data = line.split(",");
                if (data.length == 11) {
                    CustomerInfo customerInfo = new CustomerInfo();
                    customerInfo.setName(data[1].trim());
                    customerInfo.setCarMake(data[2].trim());
                    customerInfo.setCarModel(data[3].trim());
                    customerInfo.setCarColor(data[4].trim());
                    if (!data[5].trim().isEmpty()) {
                        customerInfo.setLicensePlate(data[5].trim());
                    }
                    customerInfo.setPassType(data[6].trim());
                    customerInfo.setPassExpirationDate(data[7].trim());
                    customerInfo.setUsername(data[8].trim());
                    customerInfo.setPassword(data[9].trim());
                    customerInfo.setBalance(Integer.parseInt(data[10].trim()));

                    int employeeID = 0;
                    try {
                        employeeID = Integer.parseInt(data[0].trim());
                    } catch (NumberFormatException e) {
                        // If it's not a valid employee ID, it will remain 0
                    }

                    if (employeeID != 0) {
                        customerInfo.setEmployeeID(employeeID);
                        employeeInfos.add(customerInfo);
                    } else {
                        customerInfos.add(customerInfo);
                    }
                }
                userCount++;
                System.out.println("Added User");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFinesFromCSV(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean firstLine = true;  // Flag to skip the first line
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;  // Skip the first line
                }
                String[] data = line.split(",");
                if (data.length == 7) {
                    Parking_Fine parking_fine = new Parking_Fine();
                    parking_fine.setUsername(data[0].trim());
                    parking_fine.setCitationNumber(data[1].trim());
                    parking_fine.setDate(data[2].trim());
                    parking_fine.setTime(data[3].trim());
                    parking_fine.setFineAmount(Integer.parseInt(data[4].trim()));
                    parking_fine.setReasonForFine(data[5].trim());
                    parking_fine.setPaymentStatus(data[6].trim());

                    fines.add(parking_fine);
                    System.out.println("Added Fine");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadIssuesFromDatabase(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean firstLine = true;  // Flag to skip the first line
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;  // Skip the first line
                }
                String[] data = line.split(",");
                if (data.length == 4) {
                    Issues issues = new Issues();
                    issues.setTimestamp(data[0].trim());
                    issues.setDescription(data[1].trim());
                    issues.setStatus(TicketStatus.valueOf(data[2].trim()));
                    issues.setUsername(data[3].trim());

                    issuesList.add(issues);
                    System.out.println("Added Fine");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * A method to save to the database
     */
    public void saveDatabase() {

        File newFile = new File("src\\main\\resources\\com\\team2\\cen3031spring2024team2\\Admin_database.csv");
        FileWriter saveToDatabase = null;

        try {
            //Initizes the file
            saveToDatabase = new FileWriter(newFile);

            //Writes the first line
            saveToDatabase.write("EID,Name,Car make,Car model,Car color,License plate,Pass Type,Pass expiration date,Username,Password,Balance,\n");

            //Writes the Employee Information
            for (int i = 0; i < employeeInfos.size(); i++) {
                saveToDatabase.write(employeeInfos.get(i).saveToFile());
            }

            //Writes the Customer Information
            for (int i = 0; i < customerInfos.size(); i++) {
                saveToDatabase.write(customerInfos.get(i).saveToFile());
            }

            saveToDatabase.close();

            //Catches an IO exception
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public void saveFines() {
        File newFile = new File("src\\main\\resources\\com\\team2\\cen3031spring2024team2\\FinesDatabase.csv");
        FileWriter saveToDatabase = null;

        try {
            //Initizes the file
            saveToDatabase = new FileWriter(newFile);

            //Writes the first line
            saveToDatabase.write("Username,Citation number,Date,Time,Fine amount,Reason for fine,Payment Status,\n");

            //Writes the Fine Information
            for (int i = 0; i < fines.size(); i++) {
                saveToDatabase.write(fines.get(i).toString());
            }

            saveToDatabase.close();

            //Catches an IO exception
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public void saveIssues() {
        File newFile = new File("src\\main\\resources\\com\\team2\\cen3031spring2024team2\\submitIssues.csv");
        boolean append = newFile.exists();  // Check if the file exists
        FileWriter saveToDatabase = null;

        try {
            //Initizes the file
            saveToDatabase = new FileWriter(newFile, append);

            // Write the header line only if it's a new file
            if (!append) {
                saveToDatabase.write("Timestamp,Issue Description,Status,Username,\n");
            }

            //Writes the issues Information
            for (int i = 0; i < issuesList.size(); i++) {
                saveToDatabase.write(issuesList.get(i).toString() + "\n");  // Add a new line at the end
            }

            saveToDatabase.close();

            //Catches an IO exception
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
    public void addIssue(String timeStamp, String description, TicketStatus status, String username) {
        issuesList.add(new Issues(timeStamp, description, status, username));
    }

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