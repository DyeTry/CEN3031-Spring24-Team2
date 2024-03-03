package com.team2.cen3031spring2024team2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("userLoginGUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Employee Menu");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

/*package com.team2.cen3031spring2024team2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        database.loadDatabaseFromCSV("C:\\Users\\j5osu\\IdeaProjects\\CEN3031-Spring24-Team2\\src\\main\\java\\com\\team2\\cen3031spring2024team2\\Admin_database.csv");

        List<CustInfo> employees = database.getEmployeeInfos();
        List<CustInfo> customers = database.getCustInfos();

        System.out.println("Employee Information:");
        for (CustInfo employee : employees) {
            System.out.println(employee.toString());
        }

        System.out.println("\nCustomer Information:");
        for (CustInfo customer : customers) {
            System.out.println(customer.toString());
        }
    }
}
*/