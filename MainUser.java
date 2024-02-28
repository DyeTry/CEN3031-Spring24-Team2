import java.util.Scanner;

public class MainUser {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Creating a user profile
            System.out.println("=== User Registration ===");
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            UserProfile user = new UserProfile(username, password);

            // Adding parking passes
            ParkingPass pass1 = new ParkingPass("Pass123", "Lot A");
            ParkingPass pass2 = new ParkingPass("Pass456", "Lot B");
            user.addParkingPass(pass1);
            user.addParkingPass(pass2);

            // Adding fines
            Fine fine1 = new Fine("Fine001", 50.00);
            Fine fine2 = new Fine("Fine002", 25.00);
            user.addFine(fine1);
            user.addFine(fine2);

            // Displaying assigned parking passes and fines
            user.displayParkingPasses();
            user.displayFines();
        }
    }
}
