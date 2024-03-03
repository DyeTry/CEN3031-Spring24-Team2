package com.team2.cen3031spring2024team2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<CustomerInfo> employeeInfos = new ArrayList<>();
    private List<CustomerInfo> customerInfos = new ArrayList<>();
    public int userCount = 0;

    public void loadDatabaseFromCSV(String filename) {
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
                    customerInfo.setPassExpirationDate(data[6].trim());
                    customerInfo.setPassType(data[7].trim());
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
}
