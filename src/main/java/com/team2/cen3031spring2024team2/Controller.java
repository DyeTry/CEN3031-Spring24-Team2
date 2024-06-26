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
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

import java.net.URL;

import javafx.geometry.Insets;

public class Controller implements Initializable {
    @FXML
    private Text userPassType;
    @FXML
    private ImageView handicap;
    @FXML
    private ImageView allPasses;
    @FXML
    private ImageView staff;
    @FXML
    private ImageView commuter;
    @FXML
    private ImageView resident;
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
    static String userEmailVal;


    //used for showing alerts such as success/fail messages to users
    private Alert alert = new Alert(AlertType.NONE);
    CustomerInfo customerInfo = new CustomerInfo();
    private final Database database = Main.database;

    @FXML
    private Label customerCitationUsername;
    @FXML
    private Label customerCitationBalance;

    //method called when switching to the parking fines page as a customer
    public void switchToCustomerParkingFines(ActionEvent event) throws IOException {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("customerParkingFinesTable.fxml"));
            loader.setController(this);
            Parent root = loader.load();

            customerCitationUsername.setText(permanentCustomer.getName());
            customerCitationBalance.setText("$" + permanentCustomer.getBalance());

            List<Parking_Fine> info = database.getFines();
            ObservableList<Parking_Fine> list = FXCollections.observableArrayList();

            for (Parking_Fine fine : info) {

                if (fine.getUsername().equalsIgnoreCase(permanentCustomer.getUsername()))
                {
                    list.add(fine);
                }
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
        Stage primaryStage = new Stage();
        SupportTicketManager supportTicketManager = new SupportTicketManager();
        supportTicketManager.start(primaryStage);
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
        allPasses.setVisible(false);
        handicap.setVisible(true);
        staff.setVisible(false);
        commuter.setVisible(false);
        resident.setVisible(false);
    }

    public void showAllPasses(ActionEvent event) throws IOException {
        allPasses.setVisible(true);
        handicap.setVisible(false);
        staff.setVisible(false);
        commuter.setVisible(false);
        resident.setVisible(false);
    }

    public void showStaff(ActionEvent event) throws IOException {
        allPasses.setVisible(false);
        handicap.setVisible(false);
        staff.setVisible(true);
        commuter.setVisible(false);
        resident.setVisible(false);
    }


    public void showCommuter(ActionEvent event) throws IOException {
        allPasses.setVisible(false);
        handicap.setVisible(false);
        staff.setVisible(false);
        commuter.setVisible(true);
        resident.setVisible(false);
    }


    public void showResident(ActionEvent event) throws IOException {
        allPasses.setVisible(false);
        handicap.setVisible(false);
        staff.setVisible(false);
        commuter.setVisible(false);
        resident.setVisible(true);
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
    @FXML
    public void CloseTicketButton(ActionEvent event) throws IOException {
        List<Issues> info = database.getIssuesList();
        int selectedID = issuesTable.getSelectionModel().getSelectedIndex();

        database.getIssuesList().get(selectedID).setStatus(TicketStatus.RESOLVED);
        alert.setAlertType(AlertType.CONFIRMATION);
        alert.setContentText("Issue Closed!\n");
        alert.show();

        database.saveIssues();
        switchToIssuePane(event);
    }
    @FXML
    private TableView<Issues> issuesTable;

    //placeholder until later. method called when switching to the Issues pane as an employee
    public void switchToIssuePane(ActionEvent event) throws IOException {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("employeeIssuesPane.fxml"));
            loader.setController(this);
            Parent root = loader.load();

            List<Issues> info = database.getIssuesList();
            ObservableList<Issues> list = FXCollections.observableArrayList();

            for (Issues temp : info) {
                list.add(temp);
            }


            issuesTable.setItems(list);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        citationNum.setCellValueFactory(new PropertyValueFactory<Parking_Fine, String>("citationNumber"));
        citationDate.setCellValueFactory(new PropertyValueFactory<Parking_Fine, String>("date"));
        citationTime.setCellValueFactory(new PropertyValueFactory<Parking_Fine, String>("time"));
        citationFineAmount.setCellValueFactory(new PropertyValueFactory<Parking_Fine, Integer>("fineAmount"));
        citationDescription.setCellValueFactory(new PropertyValueFactory<Parking_Fine, String>("reasonForFine"));
        citationPaymentStatus.setCellValueFactory(new PropertyValueFactory<Parking_Fine, String>("paymentStatus"));

        timeColumn.setCellValueFactory(new PropertyValueFactory<Issues, String>("timestamp"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<Issues, String>("description"));
        userColumn.setCellValueFactory(new PropertyValueFactory<Issues, String>("username"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<Issues, TicketStatus>("status"));
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

        database.addFineInformation(citationNum, formattedDate, formattedTime, permanentCustomer.getUsername(), Integer.parseInt(createFineAmount.getText()), createReasonForFine.getText(), "New");
        alert.setAlertType(AlertType.CONFIRMATION);
        alert.setContentText(
                "Fine Issued Successfully\n" +
                        "Citation Number: " + citationNum + "\n" +
                        "Date: " + formattedDate + "\n" +
                        "Time: " + formattedTime + "\n" +
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
        switchToTableView(actionEvent);
    }

    //placeholder method for resetting password
    public void onResetPassword(ActionEvent actionEvent) {
    }

    //placeholder method for editing car details as an employee
    public void onEditCar(ActionEvent actionEvent) throws IOException {
        Stage primaryStage = new Stage();
        UserCarDetailsEditor userCarDetailsEditor = new UserCarDetailsEditor();
        userCarDetailsEditor.start(primaryStage);
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
        CustomerInfo c = database.getUser(username);
        initUser(c);

        System.out.println(c);

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

    private static CustomerInfo permanentCustomer;
    public void initUser(CustomerInfo customer) {
        //Included try catches to allow error popup
        try {
            permanentCustomer = customer;
            System.out.println(customer.getName() + " found");
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private TextField SubmitIssueText;

    public void onSubmitIssueSubmit(ActionEvent event) {

        String SubmittedIssue = SubmitIssueText.getText();

        alert.setAlertType(AlertType.CONFIRMATION);
        alert.setContentText("Issue Submitted!\n");
        alert.show();

    }

    @FXML
    private Label citationUsername;

    @FXML
    private Label citationBalance;

    public void switchToTableView(ActionEvent event) throws IOException {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("UserFineTableView.fxml"));
            loader.setController(this);
            Parent root = loader.load();

            citationUsername.setText(permanentCustomer.getName());
            citationBalance.setText("$" + permanentCustomer.getBalance());

            List<Parking_Fine> info = database.getFines();
            ObservableList<Parking_Fine> list = FXCollections.observableArrayList();

            for (Parking_Fine fine : info) {
                if (fine.getUsername().equalsIgnoreCase(permanentCustomer.getUsername()))
                {
                    list.add(fine);
                }
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
    private TableColumn<Parking_Fine, Integer> citationFineAmount = new TableColumn<>("Fine Amount");
    @FXML
    private TableColumn<Parking_Fine, String> citationDescription = new TableColumn<>("Description");
    @FXML
    private TableColumn<Issues, String> timeColumn = new TableColumn<>("Time");
    @FXML
    private TableColumn<Issues, String> descriptionColumn = new TableColumn<>("Description");
    @FXML
    private TableColumn<Issues, String> userColumn = new TableColumn<>("User");
    @FXML
    private TableColumn<Issues, TicketStatus> statusColumn = new TableColumn<>("Status");
    @FXML
    private TableColumn<Parking_Fine, String> citationPaymentStatus = new TableColumn<>("Citation Status");



    @FXML
    public void addCitationEntry(ActionEvent event) throws IOException {
        switchToUserFineView(event);
    }

    @FXML
    public void reloadCitationEntry(ActionEvent event) throws IOException {
        /*
        List<Parking_Fine> info = database.getFines();
        ObservableList<Parking_Fine> list = FXCollections.observableArrayList();

        for (Parking_Fine fine : info) {
            if (fine.getUsername().equalsIgnoreCase(permanentCustomer.getUsername()))
            {
                list.add(fine);
            }
        }
        citationTable.setItems(list);

         */
        switchToTableView(event);
    }

    @FXML
    public void approveCitationEntry(ActionEvent event) throws IOException {
        List<Parking_Fine> info = database.getFines();
        String citationNum = citationTable.getSelectionModel().getSelectedItem().getCitationNumber();
        int selectedID = 0;
        int i = 0;

        for (Parking_Fine fine : info) {
            if (fine.getCitationNumber().equals(citationNum)) {
                selectedID = i;
            }
            i++;
        }

        database.getFines().get(selectedID).setPaymentStatus("Approved");

        alert.setAlertType(AlertType.CONFIRMATION);
        alert.setContentText("Issue Approved!\n");
        alert.show();

        database.saveFines();
        reloadCitationEntry(event);
    }

    @FXML
    public void deleteCitationEntry(ActionEvent event) {
        int selectedID = citationTable.getSelectionModel().getSelectedIndex();
        citationTable.getItems().remove(selectedID);
    }

    @FXML
    private TextField customerAddBalanceNum;

    @FXML
    public void onCustomerAddBalance(ActionEvent event) {
        int addBalance = Integer.parseInt(customerAddBalanceNum.getText());

        System.out.println(addBalance);

        alert.setAlertType(AlertType.CONFIRMATION);
        alert.setContentText("Funds Added!\n");
        alert.show();

        permanentCustomer.setBalance(permanentCustomer.getBalance() + addBalance);

        database.saveDatabase();
    }

    @FXML
    public void onCustomerCitationPay(ActionEvent event) {
        List<Parking_Fine> info = database.getFines();
        String citationNum = citationTable.getSelectionModel().getSelectedItem().getCitationNumber();
        int selectedID = 0;
        int i = 0;

        for (Parking_Fine fine : info) {
            if (fine.getCitationNumber().equals(citationNum)) {
                selectedID = i;
            }
            i++;
        }

        if((permanentCustomer.getBalance() - database.getFines().get(selectedID).getFineAmount() > 0 )) {

            database.getFines().get(selectedID).setPaymentStatus("Pending");

            alert.setAlertType(AlertType.CONFIRMATION);
            alert.setContentText("Issue Paid!\n");
            alert.show();

            int newBalance = permanentCustomer.getBalance() - database.getFines().get(selectedID).getFineAmount();

            permanentCustomer.setBalance(newBalance);

            database.saveDatabase();
            database.saveFines();
        } else {
            alert.setAlertType(AlertType.CONFIRMATION);
            alert.setContentText("Not Enough Funds.\nPlease Add More Funds.");
            alert.show();
        }
    }

    @FXML
    public void onCustomerCitationReload(ActionEvent event) throws IOException {
        /*
        List<Parking_Fine> info = database.getFines();
        ObservableList<Parking_Fine> list = FXCollections.observableArrayList();

        for (Parking_Fine fine : info) {
            if (fine.getUsername().equalsIgnoreCase(permanentCustomer.getUsername()))
            {
                list.add(fine);
            }
        }
        citationTable.setItems(list);

         */
        switchToCustomerParkingFines(event);
    }
}