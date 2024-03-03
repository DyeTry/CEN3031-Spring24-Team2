package com.team2.cen3031spring2024team2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.scene.control.Alert.AlertType;

public class Controller {
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

    private Alert alert = new Alert(AlertType.NONE);
    CustomerInfo customerInfo = new CustomerInfo();
    private final Database database = Main.database;

    public void switchToCustomerParkingFines(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Parking Fines.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToCustomerPasses(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("CustomerPasses.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToCustomerIssuePane(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("CustomerIssues.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToCustomerMapPane(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("CustomerMap.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToBasePane(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("employeeBasePane.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToMapPane(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("employeeMapPane.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToUserPane(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("employeeUserSearchPane.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToPassPane(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("employeePassPane.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToIssuePane(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("employeeIssuesPane.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToUserSearchResultPane(ActionEvent event) throws IOException {
        String user = userSearch.getText();

        CustomerInfo c = database.getUser(user);

        if(c == null) {
            alert.setAlertType(AlertType.ERROR);
            alert.setContentText("ERROR: Username does not exist");
            alert.show();
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("userSearchResultPane.fxml"));
            loader.setController(this);
            Parent root = loader.load();

            userName.setText(searchEntry);
            carMake.setText(c.getCarMake());
            carModel.setText(c.getCarModel());
            carColor.setText(c.getCarColor());
            passType.setText(c.getPassType());
            passExpiration.setText(c.getPassExpirationDate());
            plateNum.setText(c.getLicensePlate());
            emailVal.setText(c.getUsername());
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

    public void switchToUserFineView(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("userFineView.fxml"));
            loader.setController(this);
            Parent root = loader.load();

            fineUserName.setText(searchEntry);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onPassAssignment(ActionEvent event) throws IOException {
        //if(username is found) {
        //Set username's pass type to chosen pass type
        customerInfo.setPassType(passTitle);

        //Set pass expiration
        alert.setAlertType(AlertType.CONFIRMATION);
        alert.setContentText("Pass Assignment Successful\n"/*<username> has been assigned the <pass type> pass type*/);
        alert.show();

        /*}else {
            alert.setAlertType(AlertType.ERROR);
            alert.setContentText("ERROR: Username does not exist");
            alert.show();
        }
        */
    }

    public void onUserSearch(ActionEvent event) throws IOException {
        //if(username found) {
        //Redirect to search results page
        switchToUserSearchResultPane(event);
    }

    public void onViewFine(ActionEvent actionEvent) throws IOException {
        switchToUserFineView(actionEvent);
    }

    public void onResetPassword(ActionEvent actionEvent) {
    }

    public void onEditCar(ActionEvent actionEvent) {
    }

    public void onResidentSelection(ActionEvent event) {
        passTitle = "Resident";
        passTypeMenu.setText(passTitle);
    }

    public void onCommuterSelection(ActionEvent event) {
        passTitle = "Commuter";
        passTypeMenu.setText(passTitle);
    }

    public void onStaffSelection(ActionEvent event) {
        passTitle = "Staff";
        passTypeMenu.setText(passTitle);
    }

    public void onLogin(ActionEvent event) throws IOException {
        String username = usernameEntry.getText();
        String pass = passwordEntry.getText();

        customerInfo = database.getUser(username);
        if(customerInfo == null || !customerInfo.getPassword().equals(pass)) {
            alert.setAlertType(AlertType.ERROR);
            alert.setContentText("ERROR: Username does not exist");
            alert.show();
        }

        if(customerInfo.getEmployeeID() == 0) {
            switchToCustomerMapPane(event);
            stage.setTitle("Customer Menu");
        } else {
            switchToMapPane(event);
            stage.setTitle("Management Menu");
        }
    }

    public void onForgotPassword(ActionEvent event) {
        //enter new password and possibly verify your identity
    }
}