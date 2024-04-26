package com.team2.cen3031spring2024team2;

import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Parking_Fine {


    private String CitationNumber;
    private String Date;
    private String Time;
    private String Username;
    private int FineAmount;
    private String ReasonForFine;
    private String PaymentStatus;
    private int Balance;
    public Parking_Fine() {}

    public Parking_Fine(String CitationNumber, String Date, String Time, String Username, int FineAmount, String ReasonForFine, String PaymentStatus) {
        this.CitationNumber = CitationNumber;
        this.Date = Date;
        this.Time = Time;
        this.Username = Username;
        this.FineAmount = FineAmount;
        this.ReasonForFine = ReasonForFine;
        this.PaymentStatus = PaymentStatus;
    }





    public String getCitationNumber() {
        return CitationNumber;
    }

    public void setCitationNumber(String citationNumber) {
        CitationNumber = citationNumber;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public int getFineAmount() {
        return FineAmount;
    }

    public void setFineAmount(int fineAmount) {
        FineAmount = fineAmount;
    }

    public String getReasonForFine() {
        return ReasonForFine;
    }

    public void setReasonForFine(String reasonForFine) {
        ReasonForFine = reasonForFine;
    }

    public int getBalance() {
        return Balance;
    }

    public void setBalance(int balance) {
        Balance = balance;
    }

    public String getPaymentStatus() {
        return PaymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        PaymentStatus = paymentStatus;
    }

    @Override
    public String toString() {
        return Username + ',' + CitationNumber + ',' +Date + ',' +Time + ',' + FineAmount + ',' + ReasonForFine + "," + PaymentStatus + ",\n";
    }

}

