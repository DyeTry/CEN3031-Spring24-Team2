public class Fine {
    private String fineNumber;
    private double amount;

    public Fine(String fineNumber, double amount) {
        this.fineNumber = fineNumber;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Fine Number: " + fineNumber + ", Amount: $" + amount;
    }
}
