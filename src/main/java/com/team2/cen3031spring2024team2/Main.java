package com.team2.cen3031spring2024team2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        database.loadDatabaseFromCSV("C:\\Users\\oscar\\IdeaProjects\\CEN3031-Spring24-Team2\\src\\main\\java\\com\\team2\\cen3031spring2024team2\\Admin_database.csv");

        List<CustInfo> employees = database.getEmployeeInfos();
        List<CustInfo> customers = database.getCustInfos();

        System.out.println("Employee Information:");
        for (CustInfo employee : employees) {
            System.out.println(employee.toString());
        }

        System.out.println("\nCustomer Information:");
        for (CustInfo customer : customers) {
            System.out.println(customer.toString());
        }
    }
}