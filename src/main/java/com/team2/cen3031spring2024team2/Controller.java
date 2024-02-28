package com.team2.cen3031spring2024team2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import java.io.IOException;

public class Controller {
    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private MenuButton searchTypeMenu;

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
}