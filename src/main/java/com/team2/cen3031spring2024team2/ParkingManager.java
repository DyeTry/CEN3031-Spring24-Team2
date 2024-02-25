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

    public void login() {
        /**
         * Implement a way to login to the Parking Manager
         * Will use users login credentials
         */
    }

    /**
     * Creates a Customer and adds object to customerList
     *
     * @param name The name of the Customer
     * @param passwordString The Customer's password
     */
    public void createCustomerAccount(String name, String passwordString) {
        customerList.add(new Customer(name, passwordString, customerList.size()));
    }

    /**
     * Creates an Employee and adds object to employeeList
     *
     * @param name The name of the Employee
     * @param passwordString The Employee's password
     */
    public void createEmployeeAccount(String name, String passwordString) {
        employeeList.add(new Employee(name, passwordString, employeeList.size()));
    }

    public void registerVehicle(String make, String model, String color, String licensePlate) {
        /**
         * Implement a way to first identify who is registering the vehicle and then create the Vehicle object
         */
    }

    public void updateVehicle(String make, String model, String color, String licensePlate) {
        /**
         * Implement a way to update vehicle information
         * Might just use registerVehicle() again
         */
    }

    /**
     * A method to find Customer information
     * @param id The Customer's ID number
     * @return Returns the Customer's Information
     */
    public boolean findCustomer(int id) {

        for (Customer info : customerList) {

            if (info.getID() == id) {
                return info;
            }
        }

        return false;
    }

    public void buyParkingPass() {
        /**
         * Implement a way to buy a parking pass
         */
    }

    public void updateParkingPass() {
        /**
         * Implement a way to update/modify the user's parking pass
         * This method will be used if the user wants to upgrade or downgrade their pass
         */
    }

    public void renewParkingPass() {
        /**
         * Implement a way to check the parking passes expiration date and allow the customer to increase the timer
         * Most likely use java.time to check expiration date
         */
    }

    public void cancelParkingPass() {
        /**
         * Thought Experiment:
         * Implement a way to allow the customer to cancel their parking pass coverage
         */
    }
}