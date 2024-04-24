package com.team2.cen3031spring2024team2;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.beans.property.SimpleStringProperty;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SupportTicketManager extends Application {
    private ObservableList<SupportTicket> supportTickets = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Support Ticket Manager");

        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(10));

        // Creating the ticket submission form
        VBox submissionForm = createSubmissionForm();
        borderPane.setLeft(submissionForm);

        // Creating the ticket dashboard
        TableView<SupportTicket> ticketTable = createTicketDashboard();
        borderPane.setCenter(ticketTable);

        Scene scene = new Scene(borderPane, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private VBox createSubmissionForm() {
        VBox submissionForm = new VBox(10);
        submissionForm.setPadding(new Insets(10));

        TextField issueField = new TextField();
        issueField.setPromptText("Describe the issue");

        Button submitButton = new Button("Submit");
        submitButton.setOnAction(event -> {
            String issueDescription = issueField.getText();
            if (!issueDescription.isEmpty()) {
                LocalDateTime timestamp = LocalDateTime.now();
                String username = Controller.userEmailVal;//requires getter for current user (username functionality)
                Database database = new Database();
                database.addIssue(timestamp.toString(), issueDescription, TicketStatus.OPEN, username);
                for (Issues issue : database.getIssuesList()) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
                    supportTickets.add(new SupportTicket(LocalDateTime.parse(issue.getTimestamp().substring(0, 19), formatter), issue.getDescription(), issue.getStatus()));
                }
                database.saveIssues();
                issueField.clear();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Please describe the issue");
                alert.showAndWait();
            }
        });

        submissionForm.getChildren().addAll(new Label("Submit a Support Ticket"), issueField, submitButton);
        return submissionForm;
    }

    private TableView<SupportTicket> createTicketDashboard() {
        TableView<SupportTicket> ticketTable = new TableView<>();
        Database database = new Database();
        database.loadIssuesFromDatabase("src\\main\\resources\\com\\team2\\cen3031spring2024team2\\submitIssues.csv");
        for (Issues issue : database.getIssuesList()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
            supportTickets.add(new SupportTicket(LocalDateTime.parse(issue.getTimestamp().substring(0, 19), formatter), issue.getDescription(), issue.getStatus()));
        }
        ticketTable.setItems(supportTickets);

        TableColumn<SupportTicket, String> timestampColumn = new TableColumn<>("Timestamp");
        timestampColumn.setCellValueFactory(cellData -> {
            LocalDateTime timestamp = cellData.getValue().getTimestamp();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            return new SimpleStringProperty(timestamp.format(formatter));
        });

        TableColumn<SupportTicket, String> issueColumn = new TableColumn<>("Issue Description");
        issueColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIssueDescription()));

        TableColumn<SupportTicket, String> statusColumn = new TableColumn<>("Status");
        statusColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStatus().toString()));

        ticketTable.getColumns().addAll(timestampColumn, issueColumn, statusColumn);
        return ticketTable;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class SupportTicket {
    private LocalDateTime timestamp;
    private String issueDescription;
    private TicketStatus status;

    public SupportTicket(LocalDateTime timestamp, String issueDescription, TicketStatus status) {
        this.timestamp = timestamp;
        this.issueDescription = issueDescription;
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public TicketStatus getStatus() {
        return status;
    }
}

enum TicketStatus {
    OPEN,
    IN_PROGRESS,
    RESOLVED
}
