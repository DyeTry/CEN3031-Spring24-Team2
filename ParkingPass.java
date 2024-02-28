public class ParkingPass {
    private String passNumber;
    private String parkingLot;

    public ParkingPass(String passNumber, String parkingLot) {
        this.passNumber = passNumber;
        this.parkingLot = parkingLot;
    }

    @Override
    public String toString() {
        return "Pass Number: " + passNumber + ", Parking Lot: " + parkingLot;
    }
}