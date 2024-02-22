public class ParkingFines {
    double fineAmount;
    String reasonForFine;

    ParkingFines(double newFineAmount, String newReasonForFine) {
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
