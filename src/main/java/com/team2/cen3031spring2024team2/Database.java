package com.team2.cen3031spring2024team2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<CustInfo> employeeInfos = new ArrayList<>();
    private List<CustInfo> custInfos = new ArrayList<>();

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
                    CustInfo custInfo = new CustInfo();
                    custInfo.setName(data[1].trim());
                    custInfo.setCarMake(data[2].trim());
                    custInfo.setCarModel(data[3].trim());
                    custInfo.setCarColor(data[4].trim());
                    if (!data[5].trim().isEmpty()) {
                        custInfo.setLicensePlate(data[5].trim());
                    }
                    custInfo.setPassExpirationDate(data[6].trim());
                    custInfo.setPassType(data[7].trim());
                    custInfo.setUsername(data[8].trim());
                    custInfo.setPassword(data[9].trim());

                    int employeeID = 0;
                    try {
                        employeeID = Integer.parseInt(data[0].trim());
                    } catch (NumberFormatException e) {
                        // If it's not a valid employee ID, it will remain 0
                    }

                    if (employeeID != 0) {
                        custInfo.setEmployeeID(employeeID);
                        employeeInfos.add(custInfo);
                    } else {
                        custInfos.add(custInfo);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<CustInfo> getEmployeeInfos() {
        return employeeInfos;
    }

    public List<CustInfo> getCustInfos() {
        return custInfos;
    }

}
