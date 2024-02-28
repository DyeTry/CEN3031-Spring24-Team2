import java.util.ArrayList;
import java.util.List;

public class EmployeeProfile {
    private List<UserProfile> users;

    public EmployeeProfile() {
        this.users = new ArrayList<>();
    }

    public void assignParkingPass(UserProfile user, ParkingPass parkingPass) {
        user.addParkingPass(parkingPass);
    }

    public void assignFine(UserProfile user, Fine fine) {
        user.addFine(fine);
    }

    public void viewUserFines() {
        System.out.println("Users' Fines:");
        for (UserProfile user : users) {
            System.out.println("Username: " + user.getUsername());
            for (Fine fine : user.getFines()) {
                System.out.println(fine);
            }
            System.out.println();
        }
    }

    public void addUser(UserProfile user) {
        users.add(user);
    }
}
