package com.team2.cen3031spring2024team2;

public class Parking_Fine {

    private String CitationNumber;
    private String Date;
    private String Time;
    private String PermitNumber;
    private String Username;
    private int FineAmount;
    private String ReasonForFine;

    public Parking_Fine() {}

    public Parking_Fine(String CitationNumber, String Date, String Time, String PermitNumber, String Username, int FineAmount, String ReasonForFine) {
        this.CitationNumber = CitationNumber;
        this.Date = Date;
        this.Time = Time;
        this.PermitNumber = PermitNumber;
        this.Username = Username;
        this.FineAmount = FineAmount;
        this.ReasonForFine = ReasonForFine;
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

    public String getPermitNumber() {
        return PermitNumber;
    }

    public void setPermitNumber(String permitNumber) {
        PermitNumber = permitNumber;
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
    public void setFineAmount(int setFineAmount) {
        FineAmount = setFineAmount;
    }
    public String getReasonForFine() {
        return ReasonForFine;
    }
    public void setReasonForFine(String setReasonForFine) {
        ReasonForFine = setReasonForFine;
    }
}
