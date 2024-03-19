module com.team2.cen3031spring2024team2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.desktop;


    opens com.team2.cen3031spring2024team2 to javafx.fxml;
    exports com.team2.cen3031spring2024team2;
}