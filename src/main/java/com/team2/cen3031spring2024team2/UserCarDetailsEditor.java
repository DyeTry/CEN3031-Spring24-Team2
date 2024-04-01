package com.team2.cen3031spring2024team2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class UserCarDetailsEditor extends Application {
    private Database database;

    @Override
    public void start(Stage primaryStage) {
        database = new Database();
        database.loadDatabaseFromCSV("src\\main\\resources\\com\\team2\\cen3031spring2024team2\\Admin_database.csv");

        primaryStage.setTitle("Car Details Editor");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setVgap(10);
        grid.setHgap(10);

        TextField usernameInput = new TextField();
        usernameInput.setPromptText("Username");
        GridPane.setConstraints(usernameInput, 0, 0);

        Button searchButton = new Button("Search");
        GridPane.setConstraints(searchButton, 1, 0);

        Label nameLabel = new Label("Name:");
        GridPane.setConstraints(nameLabel, 0, 1);

        TextField nameField = new TextField();
        GridPane.setConstraints(nameField, 1, 1);

        Label makeLabel = new Label("Make:");
        GridPane.setConstraints(makeLabel, 0, 2);

        TextField makeField = new TextField();
        GridPane.setConstraints(makeField, 1, 2);

        Label modelLabel = new Label("Model:");
        GridPane.setConstraints(modelLabel, 0, 3);

        TextField modelField = new TextField();
        GridPane.setConstraints(modelField, 1, 3);

        Label colorLabel = new Label("Color:");
        GridPane.setConstraints(colorLabel, 0, 4);

        TextField colorField = new TextField();
        GridPane.setConstraints(colorField, 1, 4);

        Label licensePlateLabel = new Label("License Plate:");
        GridPane.setConstraints(licensePlateLabel, 0, 5);

        TextField licensePlateField = new TextField();
        GridPane.setConstraints(licensePlateField, 1, 5);

        Button saveButton = new Button("Save");
        GridPane.setConstraints(saveButton, 1, 6);

        grid.getChildren().addAll(usernameInput, searchButton, nameLabel, nameField, makeLabel, makeField,
                modelLabel, modelField, colorLabel, colorField, licensePlateLabel, licensePlateField, saveButton);

        searchButton.setOnAction(e -> {
            String username = usernameInput.getText();
            CustomerInfo user = database.getUser(username);
            if (user != null) {
                nameField.setText(user.getName());
                makeField.setText(user.getCarMake());
                modelField.setText(user.getCarModel());
                colorField.setText(user.getCarColor());
                licensePlateField.setText(user.getLicensePlate());
            } else {
                showAlert(Alert.AlertType.ERROR, "User not found", "User with username " + username + " not found.");
            }
        });

        saveButton.setOnAction(e -> {
            String username = usernameInput.getText();
            CustomerInfo user = database.getUser(username);
            if (user != null) {
                user.setCarMake(makeField.getText());
                user.setCarModel(modelField.getText());
                user.setCarColor(colorField.getText());
                user.setLicensePlate(licensePlateField.getText());
                showAlert(Alert.AlertType.INFORMATION, "Success", "Car details updated successfully.");
            } else {
                showAlert(Alert.AlertType.ERROR, "User not found", "User with username " + username + " not found.");
            }
        });

        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
