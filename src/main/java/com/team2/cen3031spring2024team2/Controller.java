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



    public void switchToParkingFines(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Parking Fines.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



}