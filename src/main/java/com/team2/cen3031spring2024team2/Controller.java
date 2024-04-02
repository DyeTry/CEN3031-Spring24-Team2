package com.team2.cen3031spring2024team2;

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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;

import java.net.URL;

public class Controller {
    @FXML
    private Text userPassType;
    @FXML
    private ImageView handicap;
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
    CustomerInfo customerInfo = new CustomerInfo();
    private final Database database = Main.database;

    //method called when switching to the parking fines page as a customer
    public void switchToCustomerParkingFines(ActionEvent event) throws IOException {
        //loads the fxml file
        root = FXMLLoader.load(getClass().getResource("Parking Fines.fxml"));
        //creates the stage
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //sets the scene using the loaded fxml file
        scene = new Scene(root);
        //loads the scene into the stage
        stage.setScene(scene);
        //makes the stage changes viewable to the user
        stage.show();
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

    public void showHandicap(ActionEvent event) throws IOException {
        handicap.setVisible(true);
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
        CustomerInfo c = database.getUser(user);

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
        CustomerInfo c = database.getUser(user);

        if (c == database.getUser(user)) {
            //Set username's pass type to chosen pass type
            c.setPassType(passTitle);
            database.saveDatabase();

            //Set pass expiration
            alert.setAlertType(AlertType.CONFIRMATION);
            alert.setContentText("Pass Assignment Successful\n" + c.toString()/*<username> has been assigned the <pass type> pass type*/);
            alert.show();
        } else {
            /**
             * Troubleshoot invalid user
             */
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
        CustomerInfo c = database.getUser(username);
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
        CustomerInfo c = database.getUser(user);

        if (c == database.getUser(user)) {
            //Set username's pass type to chosen pass type
            c.setPassword(password);
            database.saveDatabase();

            //Set pass expiration
            alert.setAlertType(AlertType.CONFIRMATION);
            alert.setContentText("Password Changed Successfully\n" + c.toString()/*<username> has been assigned the <pass type> pass type*/);
            alert.show();
        } else {
            /**
             * Troubleshoot invalid user
             */
            alert.setAlertType(AlertType.ERROR);
            alert.setContentText("ERROR: Username does not exist");
            alert.show();
        }
    }

    private CustomerInfo permanentCustomer;
    public void initUser(CustomerInfo customer) {
        permanentCustomer = customer;
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
}