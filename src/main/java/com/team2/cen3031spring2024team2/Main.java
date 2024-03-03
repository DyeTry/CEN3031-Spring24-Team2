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
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("userLoginGUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Employee Menu");
        stage.setScene(scene);
        stage.show();

        database.loadDatabaseFromCSV("src\\main\\resources\\com\\team2\\cen3031spring2024team2\\Admin_database.csv");
    }

    public static void main(String[] args) {
        launch();
    }
}