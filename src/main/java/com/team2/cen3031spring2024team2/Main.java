package com.team2.cen3031spring2024team2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {
    public static Database database = new Database();
    @Override
    public void start(Stage stage) throws IOException {

        //loads the login GUI pane
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("UserLogin.fxml"));

        //creates a new scene at the proper aspect ratio
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        //sets the title of the pane
        stage.setTitle("Login Page");

        //sets the scene on the stage
        stage.setScene(scene);

        //makes the stage visible to the user

        stage.show();
        //loads the current database from the CSV
        database.loadUserDatabase("src\\main\\resources\\com\\team2\\cen3031spring2024team2\\csv_files\\User_Database.csv");
        database.loadFineDatabase("src\\main\\resources\\com\\team2\\cen3031spring2024team2\\csv_files\\Fines_Database.csv");
        database.loadIssueDatabase("src\\main\\resources\\com\\team2\\cen3031spring2024team2\\csv_files\\Issues_Database.csv");
    }

    public static void main(String[] args) {
        launch();

        //Testing
        //database.loadUserDatabase("src\\main\\resources\\com\\team2\\cen3031spring2024team2\\csv_files\\User_Database.csv");
        //database.loadFineDatabase("src\\main\\resources\\com\\team2\\cen3031spring2024team2\\csv_files\\Fines_Database.csv");
        //database.loadIssueDatabase("src\\main\\resources\\com\\team2\\cen3031spring2024team2\\csv_files\\Issues_Database.csv");
    }
}