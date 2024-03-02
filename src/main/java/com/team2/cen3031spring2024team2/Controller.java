package com.team2.cen3031spring2024team2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import java.io.IOException;
import java.net.URL;

public class Controller {
    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private MenuButton searchTypeMenu;
    @FXML
    private WebView webUwfMap;
    private String searchTitle;

    private String searchEntry;

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

    public void onLoadMap(ActionEvent event) throws IOException {
        if (webUwfMap != null) {
            WebEngine engine = webUwfMap.getEngine();
            engine.load("https://www.google.com");
            engine.setJavaScriptEnabled(true);
        } else {
            System.err.println("webUwfMap is null");
        }
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
        root = FXMLLoader.load(getClass().getResource("userSearchResultPane.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToUserFineView(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("userFineView.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void onPlateAssignment(ActionEvent event) throws IOException {
        //Throw success/failure message
    }

    public void chooseIdSearch(ActionEvent event) throws IOException {
        //Change redirect of Submit button and rename "Choose Search Type" appropriately
        searchTitle = "Search by ID";
        searchTypeMenu.setText(searchTitle);
    }

    public void choosePlateSearch(ActionEvent event) throws IOException {
        //Change redirect of Submit button and rename "Choose Search Type" appropriately
        searchTitle = "Search by Plate";
        searchTypeMenu.setText(searchTitle);
    }

    public void choosePassSearch(ActionEvent event) throws IOException {
        //Change redirect of Submit button and rename "Choose Search Type" appropriately
        searchTitle = "Search by Pass";
        searchTypeMenu.setText(searchTitle);
    }

    public void chooseFineSearch(ActionEvent event) throws IOException {
        //Change redirect of Submit button and rename "Choose Search Type" appropriately
        searchTitle = "Search by Fine";
        searchTypeMenu.setText(searchTitle);
    }

    public void onSearchEntry(ActionEvent event) throws IOException {
        //Set searchEntry equal to entered search value
    }

    public void onUserSearch(ActionEvent event) throws IOException {
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
}