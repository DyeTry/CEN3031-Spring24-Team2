package com.team2.cen3031spring2024team2;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class UserCarDetailsEditor extends Application {

    private Database database;

    @Override
    public void start(Stage primaryStage) {
        database = new Database();
        database.loadDatabaseFromCSV("data.csv");

        primaryStage.setTitle("User Car Details Editor");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(8);
        grid.setHgap(10);

        Label nameLabel = new Label("Name:");
        GridPane.setConstraints(nameLabel, 0, 0);
        TextField nameInput = new TextField();
        nameInput.setPromptText("Enter name");
        GridPane.setConstraints(nameInput, 1, 0);

        Label makeLabel = new Label("Make:");
        GridPane.setConstraints(makeLabel, 0, 1);
        TextField makeInput = new TextField();
        makeInput.setPromptText("Enter make");
        GridPane.setConstraints(makeInput, 1, 1);

        Label modelLabel = new Label("Model:");
        GridPane.setConstraints(modelLabel, 0, 2);
        TextField modelInput = new TextField();
        modelInput.setPromptText("Enter model");
        GridPane.setConstraints(modelInput, 1, 2);

        Label colorLabel = new Label("Color:");
        GridPane.setConstraints(colorLabel, 0, 3);
        TextField colorInput = new TextField();
        colorInput.setPromptText("Enter color");
        GridPane.setConstraints(colorInput, 1, 3);

        Label licensePlateLabel = new Label("License Plate:");
        GridPane.setConstraints(licensePlateLabel, 0, 4);
        TextField licensePlateInput = new TextField();
        licensePlateInput.setPromptText("Enter license plate");
        GridPane.setConstraints(licensePlateInput, 1, 4);

        Button saveButton = new Button("Save");
        GridPane.setConstraints(saveButton, 1, 5);
        saveButton.setOnAction(e -> {
            String name = nameInput.getText();
            String make = makeInput.getText();
            String model = modelInput.getText();
            String color = colorInput.getText();
            String licensePlate = licensePlateInput.getText();

            //get the user by name from the database
            CustomerInfo user = database.getUser(name);
            if (user != null) {
                user.setCarMake(make);
                user.setCarModel(model);
                user.setCarColor(color);
                user.setLicensePlate(licensePlate);

                System.out.println("User's car details updated successfully.");
            } else {
                System.out.println("User not found.");
            }
        });

        grid.getChildren().addAll(nameLabel, nameInput, makeLabel, makeInput, modelLabel, modelInput, colorLabel, colorInput, licensePlateLabel, licensePlateInput, saveButton);

        Scene scene = new Scene(grid, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


