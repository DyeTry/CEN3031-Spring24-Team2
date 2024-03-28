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
    private String file;
    public int userCount = 0;

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
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
                if (data.length == 10) {
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
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<CustomerInfo> getEmployeeInfos() {
        return employeeInfos;
    }

    public List<CustomerInfo> getCustomerInfos() {
        return customerInfos;
    }

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

    public void createCustomerProfile(String name, String username, String password, String make, String model, String color, String licensePlate) {
        customerInfos.add(new CustomerInfo(name, username, password, make, model, color, licensePlate));
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
            saveToDatabase.write("EID,Name,Car make,Car model,Car color,License plate,Pass Type,Pass expiration date,Username,Password,\n");

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
}
