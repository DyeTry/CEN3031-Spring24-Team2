import java.util.ArrayList;
import java.util.List;

public class UserProfile {
    private String username;
    private String password;
    private List<ParkingPass> parkingPasses;
    private List<Fine> fines;

    public UserProfile(String username, String password) {
        this.username = username;
        this.password = password;
        this.parkingPasses = new ArrayList<>();
        this.fines = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<ParkingPass> getParkingPasses() {
        return parkingPasses;
    }

    public List<Fine> getFines() {
        return fines;
    }

    public void addParkingPass(ParkingPass parkingPass) {
        this.parkingPasses.add(parkingPass);
    }

    public void addFine(Fine fine) {
        this.fines.add(fine);
    }

    public void displayParkingPasses() {
        System.out.println("Assigned Parking Passes:");
        for (ParkingPass pass : parkingPasses) {
            System.out.println(pass);
        }
    }

    public void displayFines() {
        System.out.println("Fines:");
        for (Fine fine : fines) {
            System.out.println(fine);
        }
}

}