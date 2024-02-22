public class ParkingFines {
    double fineAmount;
    String reasonForFine;

    ParkingFines(double newFineAmount, String newReasonForFine) {
        fineAmount = newFineAmount;
        reasonForFine = newReasonForFine;
    }

    public double getFineAmount() {
        return fineAmount;
    }

    public String getReasonForFine() {
        return reasonForFine;
    }
}
