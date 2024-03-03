package com.team2.cen3031spring2024team2;

public class Parking_Fines {

    private double fineAmount;

    private String reasonForFine;

    public Parking_Fines(double newFineAmount, String newReasonForFine) {
        setFineAmount(newFineAmount);
        setReasonForFine(newReasonForFine);
    }

    public void setFineAmount(double fineAmount) {
        this.fineAmount = fineAmount;
    }

    public double getFineAmount() {
        return fineAmount;
    }

    public void setReasonForFine(String reasonForFine) {
        this.reasonForFine = reasonForFine;
    }

    public String getReasonForFine() {
        return reasonForFine;
    }
}
