package src.main.java.com.team2.cen3031spring2024team2;

public class ParkingFines {
    double fineAmount;
    String dateForFine;

    ParkingFines(double newFineAmount, String newDateForFine) {
        setFineAmount(newFineAmount);
        setDateForFine(newDateForFine);
    }

    public void setFineAmount(double fineAmount) {
        this.fineAmount = fineAmount;
    }

    public double getFineAmount() {
        return fineAmount;
    }

    public void setDateForFine(String dateForFine) {
        this.dateForFine = dateForFine;
    }

    public String getDateForFine() {
        return dateForFine;
    }
}