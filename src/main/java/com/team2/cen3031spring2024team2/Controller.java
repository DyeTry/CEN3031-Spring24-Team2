package com.team2.cen3031spring2024team2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import java.lang.annotation.Target;
import java.net.URL;
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
    TextField userSearch;
    @FXML
    Label userName;
    @FXML
    Label fineUserName;
    @FXML
    Text carMake;
    @FXML
    Text carModel;
    @FXML
    Text carColor;
    @FXML
    Text plateNum;
    @FXML
    Text emailVal;
    @FXML
    Text userType;
    @FXML
    Text passType;
    @FXML
    Text passExpiration;

    private Alert alert = new Alert(AlertType.NONE);
    CustInfo custInfo = new CustInfo();

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
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("userSearchResultPane.fxml"));
            loader.setController(this);
            Parent root = loader.load();

            userName.setText(searchEntry);
            carMake.setText(custInfo.getCarMake());
            carModel.setText(custInfo.getCarModel());
            carColor.setText(custInfo.getCarColor());
            passType.setText(custInfo.getPassType());
            passExpiration.setText(custInfo.getPassExpirationDate());
            if(custInfo.getEmployeeID() == 0) {
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
        custInfo.setPassType(passTitle);

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

    public void onSearchEntry(ActionEvent event) throws IOException {
        //if(username found) {
        //Set searchEntry equal to entered search value
        searchEntry = userSearch.getText();
        System.out.println(searchEntry);
        /*} else {
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
}