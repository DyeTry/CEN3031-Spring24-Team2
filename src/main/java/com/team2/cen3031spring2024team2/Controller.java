package com.team2.cen3031spring2024team2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    /**
     * Objects and Methods to be used throughout the Controller class
     */

    private final Alert alert = new Alert(Alert.AlertType.NONE); //used for showing alerts such as success/fail messages to users

    private final Database database = Main.database; //An object to use Database methods

    private static Customer customerInformation; //An object to initialize a Customer

    @FXML
    private Stage stage; //IDK ask Jeremiah, Rikki, or Oscar

    @FXML
    private Scene scene; //IDK ask Jeremiah, Rikki, or Oscar

    @FXML
    private Parent root; //IDK ask Jeremiah, Rikki, or Oscar

    @FXML
    private TableView<Parking_Fine> citationTable; //The Parking Fine Table container

    @FXML
    private TableColumn<Parking_Fine, String> citationNum = new TableColumn<>("Citation Number"); //The Parking Fine Citation Number column

    @FXML
    private TableColumn<Parking_Fine, String> citationDate = new TableColumn<>("Date"); //The Parking Fine Date column

    @FXML
    private TableColumn<Parking_Fine, String> citationTime = new TableColumn<>("Time"); //The Parking Fine Time column

    @FXML
    private TableColumn<Parking_Fine, String> citationPermitNum = new TableColumn<>("Permit Number"); //The Parking Fine Permit Number column

    @FXML
    private TableColumn<Parking_Fine, Integer> citationFineAmount = new TableColumn<>("Fine Amount"); //The Parking Fine Citation Amount column

    @FXML
    private TableColumn<Parking_Fine, String> citationDescription = new TableColumn<>("Description"); //The Parking Fine Description column

    //A method to initialize a given User
    public void initializeUser(Customer customer) {
        customerInformation = customer;
        System.out.println(customer.getName() + " found"); //TESTING DELETE LATER
    }

    //A method to initialize the Fine Table columns
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        citationNum.setCellValueFactory(new PropertyValueFactory<Parking_Fine, String>("citationNumber"));
        citationDate.setCellValueFactory(new PropertyValueFactory<Parking_Fine, String>("date"));
        citationTime.setCellValueFactory(new PropertyValueFactory<Parking_Fine, String>("time"));
        citationPermitNum.setCellValueFactory(new PropertyValueFactory<Parking_Fine, String>("permitNumber"));
        citationFineAmount.setCellValueFactory(new PropertyValueFactory<Parking_Fine, Integer>("fineAmount"));
        citationDescription.setCellValueFactory(new PropertyValueFactory<Parking_Fine, String>("reasonForFine"));
    }

    //******************************************************************************************************

    /**
     * Customer GUI Objects and Methods
     */

    @FXML
    private Text userPassType; //An object to initialize the Customer's parking pass type

    @FXML
    private Text userLicensePlate; //An object to initialize the Customer's license plate

    @FXML
    private Text userMake; //An object to initialize the Customer's car make

    @FXML
    private Text userModel; //An object to initialize the Customer's car model

    @FXML
    private Text userPassExpiration; //An object to initialize the Customer's parking pass expiration date

    @FXML
    private TextField SubmitIssueText; //An object to initialize the Customer's issue ticket

    //method called when switching to the map pane as a Customer
    public void switchToCustomerMapPane(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("CustomerMenuMap.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //method called when switching to the parking fines page as a Customer
    public void switchToCustomerParkingFines(ActionEvent event) throws IOException {

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("CustomerViewParkingFines.fxml")));

        /*

        try {
            customerCitationUsername.setText(permanentCustomer.getName());
            customerCitationBalance.setText("$" + permanentCustomer.getBalance());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        List<Parking_Fine> info = database.getFineList();
        ObservableList<Parking_Fine> list = FXCollections.observableArrayList();

        for (Parking_Fine fine : info) {
            list.add(fine);
        }

        citationTable.setItems(list);

         */

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //method called when switching to the parking pass page as a Customer
    public void switchToCustomerPasses(ActionEvent event) throws IOException {

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("CustomerViewParkingPass.fxml")));

        System.out.println(customerInformation.getParkingPass().getPassType());
        System.out.println(customerInformation.getVehicle().getLicencePlate());
        System.out.println(customerInformation.getVehicle().getMake());
        System.out.println(customerInformation.getVehicle().getModel());
        System.out.println(customerInformation.getParkingPass().getPassExpirationDate());

        userPassType.setText("Hello");
        //userLicensePlate.setText(customerInformation.getVehicle().getLicencePlate());
        //userMake.setText(customerInformation.getVehicle().getMake());
        //userModel.setText(customerInformation.getVehicle().getModel());
        //userPassExpiration.setText(customerInformation.getParkingPass().getPassExpirationDate());

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        /*
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CustomerViewParkingPass.fxml"));
            loader.setController(this);
            Parent root = loader.load();

            //test code hard coding the page to load a specific user's information. Database calls must be programmed
            userPassType.setTextContent(customerInformation.getParkingPass().getPassType());
            userLicensePlate.setTextContent(customerInformation.getVehicle().getLicencePlate());
            userMake.setTextContent(customerInformation.getVehicle().getMake());
            userModel.setTextContent(customerInformation.getVehicle().getModel());
            userPassExpiration.setTextContent(customerInformation.getParkingPass().getPassExpirationDate());

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

         */
    }

    //method called when switching to the issues pane as a customer. this is currently a place-holder pane until we create issue submission functionality
    public void switchToCustomerIssuePane(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("CustomerSubmitIssues.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        System.out.println(customerInformation.toString());
    }

    //A method for Customers to pay citations
    @FXML
    public void onCustomerCitationPay(ActionEvent event) {
        int selectedID = citationTable.getSelectionModel().getSelectedIndex();
        citationTable.getItems().remove(selectedID);

        database.getFineList().remove(selectedID);

        alert.setAlertType(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Issue Paid!\n");
        alert.show();

        database.saveFines();
    }

    //A method to reload the Parking Fine table
    @FXML
    public void onCustomerCitationReload(ActionEvent event) {
        List<Parking_Fine> info = database.getFineList();
        ObservableList<Parking_Fine> list = FXCollections.observableArrayList();

        for (Parking_Fine fine : info) {
            list.add(fine);
        }

        citationTable.setItems(list);
    }

    //A method to allow Customers to submit Issue Tickets
    public void onSubmitIssueSubmit(ActionEvent event) {

        String SubmittedIssue = SubmitIssueText.getText();
        System.out.println(customerInformation.toString());
        database.addCustomerIssue(customerInformation.getUsername(),SubmittedIssue);


        alert.setAlertType(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Issue Submitted!\n");
        alert.show();
    }

    //******************************************************************************************************

    /**
     * Employee GUI Objects and Methods
     */

    //method called when switching to the map pane as an Employee
    public void switchToEmployeeMapPane(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("EmployeeMenuMap.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //method called when switching to the User Search pane as an Employee
    public void switchToEmployeeUserSearchPane(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("employeeUserSearchPane.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //method called when switching to the pass assignment pane as an Employee
    public void switchToEmployeeAssignParkingPass(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("EmployeeAssignParkingPass.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //Method called when switching to the Issues pane as an Employee
    public void switchEmployeeViewIssuesTable(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("EmployeeViewIssuesTable.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //******************************************************************************************************

    /**
     * User GUI Objects and Methods
     */

    @FXML
    private TextField loginUsername; //An object to initialize the User's username

    @FXML
    private PasswordField loginPassword; //An object to initialize the User's password

    @FXML
    private TextField forgotPasswordUsername; //An object to initialize the User's username

    @FXML
    private PasswordField forgotPasswordNewPassword; //An object to initialize the User's new password

    @FXML
    private TextField createUsername; //An object to initialize a new User's username

    @FXML
    private TextField createEmail; //An object to initialize a new User's email

    @FXML
    private PasswordField createPassword; //An object to initialize a new User's password

    @FXML
    private TextField createBalance; //An object to initialize a new User's balance

    @FXML
    private TextField createMake; //An object to initialize a new User's car make

    @FXML
    private TextField createModel; //An object to initialize a new User's car model

    @FXML
    private TextField createColor; //An object to initialize a new User's car color

    @FXML
    private TextField createPlate; //An object to initialize a new User's car license plate

    //A method for the User to log into the program
    public void onLoginScreen_Login(ActionEvent actionEvent) throws IOException {

        //temp variable to store entered username for validity checking
        String username = loginUsername.getText();

        //Initializes the Customer
        Customer c = database.getUser(username);
        initializeUser(c);

        //temp variable to store password for validity checking
        String pass = loginPassword.getText();

        //searches database for entered username
        customerInformation = database.getUser(loginUsername.getText());

        //throws error if the username is not found in the database or if the password is incorrect
        if(customerInformation == null || !customerInformation.getPassword().equals(pass)) {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("ERROR: Username does not exist");
            alert.show();
        }

        //checks if the logged-in user is a customer or employee and loads the proper pane accordingly
        if(customerInformation.getId() == 0) {
            switchToCustomerMapPane(actionEvent);
            stage.setTitle("Customer Menu");
        } else {
            switchToEmployeeMapPane(actionEvent);
            stage.setTitle("Management Menu");
        }
    }

    //A method for the User to change their password
    public void onLoginScreen_ForgotPassword(ActionEvent actionEvent) throws IOException {
        //enter new password and possibly verify your identity
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("UserForgotPassword.fxml")));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //A method to create a new User account
    public void onLoginScreen_CreateAccount(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("UserCreateAccount.fxml")));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void onForgotPasswordSubmit(ActionEvent actionEvent) {

        String user = forgotPasswordUsername.getText();
        String password = forgotPasswordNewPassword.getText();
        Customer c = database.getUser(user);

        if (c == database.getUser(user)) {

            //Set username's pass type to chosen pass type
            c.setPassword(password);
            database.saveDatabase();

            //Set pass expiration
            alert.setAlertType(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Password Changed Successfully\n" + c.getUsername());
            alert.show();
        } else {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("ERROR: Username does not exist");
            alert.show();
        }
    }

    //A method to submit newly created accounts
    public void onSubmitAccount(ActionEvent actionEvent) {

        //temp variable for setting user's name
        String name = createUsername.getText();

        //temp variable for setting user's email
        String email = createEmail.getText();

        //temp variable for setting user's password
        String password = createPassword.getText();

        //temp variable for setting user's car make
        String make = createMake.getText();

        //temp variable for setting user's car model
        String model = createModel.getText();

        //temp variable for setting user's car color
        String color = createColor.getText();

        //temp variable for setting user's license plate
        String plate = createPlate.getText();

        //temp variable for setting user's license plate
        int balance = Integer.parseInt(createBalance.getText());

        //adds new user to the database based off entered information
        database.addCustomerProfile(name, email, password, make, model, color, plate, balance);
        database.saveDatabase();

        //alert to show successful account creation
        alert.setAlertType(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Account Creation Successful\n");
        alert.show();
    }

    //******************************************************************************************************
}
/*

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;

import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

import java.net.URL;


public class Controller implements Initializable {
    @FXML
    private Text userPassType;
    @FXML
    private Text userModel;
    @FXML
    private Text userMake;
    @FXML
    private Text userLicensePlate;
    @FXML
    private Text userPassExpiration;
    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private MenuButton passTypeMenu;
    private String passTitle;
    private String searchEntry;
    @FXML
    private TextField userSearch;
    @FXML
    private Label userName;
    @FXML
    private Label fineUserName;
    @FXML
    private Text carMake;
    @FXML
    private Text carModel;
    @FXML
    private Text carColor;
    @FXML
    private Text plateNum;
    @FXML
    private Text emailVal;
    @FXML
    private Text userType;
    @FXML
    private Text passType;
    @FXML
    private Text passExpiration;
    @FXML
    private PasswordField passwordEntry;
    private String passwordVal;
    @FXML
    private TextField usernameEntry;
    private String usernameVal;
    @FXML
    private TextField createUsername;
    @FXML
    private TextField createPassword;
    @FXML
    private TextField createEmail;
    @FXML
    private TextField createMake;
    @FXML
    private TextField createModel;
    @FXML
    private TextField createColor;
    @FXML
    private TextField createPlate;
    @FXML
    private TextField createBalance;
    String userEmailVal;

    //used for showing alerts such as success/fail messages to users
    private Alert alert = new Alert(AlertType.NONE);
    Customer customerInfo = new Customer();
    private final Database database = Main.database;

    //method called when switching to the parking fines page as a customer
    public void switchToCustomerParkingFines(ActionEvent event) throws IOException {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Parking Fines.fxml"));
            loader.setController(this);
            Parent root = loader.load();

            try {
                customerCitationUsername.setText(permanentCustomer.getName());
                customerCitationBalance.setText("$" + permanentCustomer.getBalance());
            } catch (NullPointerException e) {
                e.printStackTrace();
            }

            List<Parking_Fine> info = database.getFines();
            ObservableList<Parking_Fine> list = FXCollections.observableArrayList();

            for (Parking_Fine fine : info) {
                list.add(fine);
            }
            citationTable.setItems(list);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //method called when switching to the pass page as a customer
    public void switchToCustomerPasses(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CustomerPasses.fxml"));
            loader.setController(this);
            Parent root = loader.load();

            //test code hard coding the page to load a specific user's information. Database calls must be programmed
            userPassType.setText(database.getUser("Psail@gmail.com").getPassType());
            userLicensePlate.setText(database.getUser("Psail@gmail.com").getLicensePlate());
            userMake.setText(database.getUser("Psail@gmail.com").getCarMake());
            userModel.setText(database.getUser("Psail@gmail.com").getCarModel());
            userPassExpiration.setText(database.getUser("Psail@gmail.com").getPassExpirationDate());

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //method called when switching to the issues pane as a customer. this is currently a place-holder pane until we create issue submission functionality
    public void switchToCustomerIssuePane(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("CustomerIssues.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //method called when switching to the map pane as a customer
    public void switchToCustomerMapPane(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("CustomerMap.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //currently not in use, an empty employee pane used to template all other employee panes
    public void switchToBasePane(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("employeeBasePane.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //method called when switching to the map pane as an employee
    public void switchToMapPane(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("employeeMapPane.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //method called when switching to the User Search pane as an employee
    public void switchToUserPane(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("employeeUserSearchPane.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //method called when switching to the pass assignment pane as an employee
    public void switchToPassPane(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("employeePassPane.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //placeholder until later. method called when switching to the Issues pane as an employee
    public void switchToIssuePane(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("employeeIssuesPane.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //method called after searching for a user in the User Search pane
    public void switchToUserSearchResultPane(ActionEvent event) throws IOException {
        //variable to capture the username that was entered
        String user = userSearch.getText();

        //variable to collect the information of the user searched for
        Customer c = database.getUser(user);

        //checks if the user is not in the database, if they do not exist it throws an error to the user
        if(c == null) {
            alert.setAlertType(AlertType.ERROR);
            alert.setContentText("ERROR: Username does not exist");
            alert.show();
            return;
        }

        //try-catch for loading the user's data in the search result pane
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("userSearchResultPane.fxml"));
            loader.setController(this);
            Parent root = loader.load();

            //loads the username of the searched user in the GUI as the header
            userName.setText(c.getName());
            //loads the car make of the searched user in the GUI
            carMake.setText(c.getCarMake());
            //loads the car model of the searched user in the GUI
            carModel.setText(c.getCarModel());
            //loads the car color of the searched user in the GUI
            carColor.setText(c.getCarColor());
            //loads the pass type of the searched user in the GUI
            passType.setText(c.getPassType());
            //loads the pass expiration of the searched user in the GUI
            passExpiration.setText(c.getPassExpirationDate());
            //loads the plate # of the searched user in the GUI
            plateNum.setText(c.getLicensePlate());
            //loads the email of the searched user in the GUI
            emailVal.setText(c.getUsername());

            //checks if they are a customer or an employee and loads the type found in the database into the GUI
            if(customerInfo.getEmployeeID() == 0) {
                userType.setText("Customer");
            } else {
                userType.setText("Employee");
            }

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private Text userBalance;
    @FXML
    private Text userCitationNum;

    //method called when switching to the fine view of a searched user as an employee (does not yet load the fine database)
    public void switchToUserFineView(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("userFineView.fxml"));
            loader.setController(this);
            Parent root = loader.load();

            //Fills in selected user's information
            fineUserName.setText(permanentCustomer.getName());
            userBalance.setText("$" + Integer.toString(permanentCustomer.getBalance()));
            userCitationNum.setText(Integer.toString(database.getFineCount(permanentCustomer.getUsername())));

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private TextField createReasonForFine;
    @FXML
    private TextField createFineAmount;

    public void onCitationSubmit(ActionEvent event) {

        LocalDate localDate = LocalDate.now();
        DateTimeFormatter date = DateTimeFormatter.ofPattern("M/d/yyyy");
        String formattedDate = localDate.format(date);

        LocalTime localTime = LocalTime.now();
        DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm");
        String formattedTime = localTime.format(time);

        String citationNum = database.randomStringGenerator(10);
        String permitNum = database.randomStringGenerator(6); //Placeholder until permit number is implemented

        database.addFineInformation(citationNum, formattedDate, formattedTime, permitNum, permanentCustomer.getUsername(), Integer.parseInt(createFineAmount.getText()), createReasonForFine.getText());
        alert.setAlertType(AlertType.CONFIRMATION);
        alert.setContentText(
                "Fine Issued Successfully\n" +
                        "Citation Number: " + citationNum + "\n" +
                        "Date: " + formattedDate + "\n" +
                        "Time: " + formattedTime + "\n" +
                        "Permit Number: " + permitNum + "\n" +
                        "Name: " + permanentCustomer.getName() + "\n" +
                        "Reason For Fine: " + createReasonForFine.getText() + "\n" +
                        "Citation Amount: $" + createFineAmount.getText()
        );
        alert.show();
        database.saveFines();
    }

    @FXML
    private TextField usernameField;

    //method called when a user is assigned a pass
    public void onPassAssignment(ActionEvent event) throws IOException {

        String user = usernameField.getText();
        Customer c = database.getUser(user);

        if (c == database.getUser(user)) {
            //Set username's pass type to chosen pass type
            c.setPassType(passTitle);
            database.saveDatabase();

            //Set pass expiration
            alert.setAlertType(AlertType.CONFIRMATION);
            alert.setContentText("Pass Assignment Successful\n" + c.toString());
            alert.show();
        } else {
            alert.setAlertType(AlertType.ERROR);
            alert.setContentText("ERROR: Username does not exist");
            alert.show();
        }
    }

    //method called when searching for a user as an employee
    public void onUserSearch(ActionEvent event) throws IOException {
        //if(username found) {
        //Redirect to search results page
        String username = userSearch.getText();
        Customer c = database.getUser(username);
        initUser(c);

        switchToUserSearchResultPane(event);
    }

    public void onViewFine(ActionEvent actionEvent) throws IOException {
        switchToUserFineView(actionEvent);
    }

    //placeholder method for resetting password
    public void onResetPassword(ActionEvent actionEvent) {
    }

    //placeholder method for editing car details as an employee
    public void onEditCar(ActionEvent actionEvent) {
    }

    //method called when selecting "Resident" as a choice in the pass assignment pane as an employee
    public void onResidentSelection(ActionEvent event) {
        passTitle = "Resident";
        passTypeMenu.setText(passTitle);
    }

    //method called when selecting "Commuter" as a choice in the pass assignment pane as an employee
    public void onCommuterSelection(ActionEvent event) {
        passTitle = "Commuter";
        passTypeMenu.setText(passTitle);
    }

    //method called when selecting "Staff" as a choice in the pass assignment pane as an employee
    public void onStaffSelection(ActionEvent event) {
        passTitle = "Staff";
        passTypeMenu.setText(passTitle);
    }

    //Method called when attempting to log into the program
    public void onLogin(ActionEvent event) throws IOException {
        //temp variable to store entered username for validity checking
        String username = usernameEntry.getText();
        Customer c = database.getUser(username);
        initUser(c);
        //saving email value for later use
        userEmailVal = usernameEntry.getText();
        //temp variable to store password for validity checking
        String pass = passwordEntry.getText();

        //searches database for entered username
        customerInfo = database.getUser(username);

        //throws error if the username is not found in the database or if the password is incorrect
        if(customerInfo == null || !customerInfo.getPassword().equals(pass)) {
            alert.setAlertType(AlertType.ERROR);
            alert.setContentText("ERROR: Username does not exist");
            alert.show();
        }

        //checks if the logged-in user is a customer or employee and loads the proper pane accordingly
        if(customerInfo.getEmployeeID() == 0) {
            switchToCustomerMapPane(event);
            stage.setTitle("Customer Menu");
        } else {
            switchToMapPane(event);
            stage.setTitle("Management Menu");
        }
    }

    //Placeholder method for forgot password functionality
    public void onForgotPassword(ActionEvent event) throws IOException {
        //enter new password and possibly verify your identity
        root = FXMLLoader.load(getClass().getResource("forgotPasswordPane.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //Method called when creating an account to load the Create Account pane
    public void onCreateAccount(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("createAccount.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //Method called when submitting a new account for creation
    public void onSubmitAccount(ActionEvent event) {
        //temp variable for setting user's name
        String name = createUsername.getText();
        //temp variable for setting user's email
        String email = createEmail.getText();
        //temp variable for setting user's password
        String password = createPassword.getText();
        //temp variable for setting user's car make
        String make = createMake.getText();
        //temp variable for setting user's car model
        String model = createModel.getText();
        //temp variable for setting user's car color
        String color = createColor.getText();
        //temp variable for setting user's license plate
        String plate = createPlate.getText();
        //temp variable for setting user's license plate
        int balance = Integer.parseInt(createBalance.getText());

        //adds new user to the database based off entered information
        database.createCustomerProfile(name, email, password, make, model, color, plate, balance);
        database.saveDatabase();

        //alert to show successful account creation
        alert.setAlertType(AlertType.CONFIRMATION);
        alert.setContentText("Account Creation Successful\n");
        alert.show();
    }

    @FXML
    TextField forgotPasswordUsername;

    @FXML
    TextField forgotPasswordNewPassword;

    public void onForgotPasswordSubmit(ActionEvent event) {
        String user = forgotPasswordUsername.getText();
        String password = forgotPasswordNewPassword.getText();
        Customer c = database.getUser(user);

        if (c == database.getUser(user)) {
            //Set username's pass type to chosen pass type
            c.setPassword(password);
            database.saveDatabase();

            //Set pass expiration
            alert.setAlertType(AlertType.CONFIRMATION);
            alert.setContentText("Password Changed Successfully\n" + c.toString());
            alert.show();
        } else {
            alert.setAlertType(AlertType.ERROR);
            alert.setContentText("ERROR: Username does not exist");
            alert.show();
        }
    }

    private Customer permanentCustomer;
    public void initUser(Customer customer) {
        permanentCustomer = customer;
        System.out.println(customer.getName() + " found");
    }

    @FXML
    private TextField SubmitIssueText;

    public void onSubmitIssueSubmit(ActionEvent event) {

        String SubmittedIssue = SubmitIssueText.getText();
        database.createCustomerIssue(SubmittedIssue);


        alert.setAlertType(AlertType.CONFIRMATION);
        alert.setContentText("Issue Submitted!\n");
        alert.show();

    }

    @FXML
    private Label citationUsername;

    public void switchToTableView(ActionEvent event) throws IOException {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("UserFineTableView.fxml"));
            loader.setController(this);
            Parent root = loader.load();

            citationUsername.setText(permanentCustomer.getName());

            List<Parking_Fine> info = database.getFines();
            ObservableList<Parking_Fine> list = FXCollections.observableArrayList();

            for (Parking_Fine fine : info) {
                list.add(fine);
            }
            citationTable.setItems(list);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private TableView<Parking_Fine> citationTable;
    @FXML
    private TableColumn<Parking_Fine, String> citationNum = new TableColumn<>("Citation Number");
    @FXML
    private TableColumn<Parking_Fine, String> citationDate = new TableColumn<>("Date");
    @FXML
    private TableColumn<Parking_Fine, String> citationTime = new TableColumn<>("Time");
    @FXML
    private TableColumn<Parking_Fine, String> citationPermitNum = new TableColumn<>("Permit Number");
    @FXML
    private TableColumn<Parking_Fine, Integer> citationFineAmount = new TableColumn<>("Fine Amount");
    @FXML
    private TableColumn<Parking_Fine, String> citationDescription = new TableColumn<>("Description");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        citationNum.setCellValueFactory(new PropertyValueFactory<Parking_Fine, String>("citationNumber"));
        citationDate.setCellValueFactory(new PropertyValueFactory<Parking_Fine, String>("date"));
        citationTime.setCellValueFactory(new PropertyValueFactory<Parking_Fine, String>("time"));
        citationPermitNum.setCellValueFactory(new PropertyValueFactory<Parking_Fine, String>("permitNumber"));
        citationFineAmount.setCellValueFactory(new PropertyValueFactory<Parking_Fine, Integer>("fineAmount"));
        citationDescription.setCellValueFactory(new PropertyValueFactory<Parking_Fine, String>("reasonForFine"));
    }

    @FXML
    public void addCitationEntry(ActionEvent event) {
        List<Parking_Fine> info = database.getFines();
        ObservableList<Parking_Fine> list = FXCollections.observableArrayList();

        for (Parking_Fine fine : info) {
            list.add(fine);
        }
        citationTable.setItems(list);
    }

    @FXML
    public void deleteCitationEntry(ActionEvent event) {
        int selectedID = citationTable.getSelectionModel().getSelectedIndex();
        citationTable.getItems().remove(selectedID);
    }

    @FXML
    public void onCustomerCitationPay(ActionEvent event) {
        int selectedID = citationTable.getSelectionModel().getSelectedIndex();
        citationTable.getItems().remove(selectedID);

        database.getFines().remove(selectedID);

        alert.setAlertType(AlertType.CONFIRMATION);
        alert.setContentText("Issue Paid!\n");
        alert.show();

        database.saveFines();
    }

    @FXML
    public void onCustomerCitationReload(ActionEvent event) {
        List<Parking_Fine> info = database.getFines();
        ObservableList<Parking_Fine> list = FXCollections.observableArrayList();

        for (Parking_Fine fine : info) {
            list.add(fine);
        }
        citationTable.setItems(list);
    }

}

 */