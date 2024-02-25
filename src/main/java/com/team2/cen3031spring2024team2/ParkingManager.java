import java.util.ArrayList;

public class Parking_Manager {

    private ArrayList<Customer> customerList = new ArrayList<Customer>();

    private ArrayList<Employee> employeeList = new ArrayList<Employee>();

    private ArrayList<Parking_Fines> finesList = new ArrayList<Parking_Fines>();

    private ArrayList<Parking_Pass> passList = new ArrayList<Parking_Pass>();

    private ArrayList<Parking_Area> areaList = new ArrayList<Parking_Area>();

    public Parking_Manager() {
        /**
         * Assuming the database is a .csv file
         * Implement the file IO here - Implement a way to read file IO and save it in ArrayList
         */
    }

    public void createCustomerAccount(String name, String passwordString) {
        customerList.add(new Customer(name, passwordString, customerList.size()));
    }

    public void createEmployeeAccount(String name, String passwordString) {
        employeeList.add(new Employee(name, passwordString, employeeList.size()));
    }

    public void registerVehicle(String make, String model, String color, String licensePlate) {
        /**
         * Implement a way to first identify who is registering the vehicle and then create the Vehicle object
         */
    }
}