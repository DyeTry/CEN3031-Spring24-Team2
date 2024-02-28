import java.util.Scanner;

public class MainEmployee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creating an employee profile
        EmployeeProfile employee = new EmployeeProfile();

        // Creating user profiles
        UserProfile user1 = new UserProfile("alice", "password123");
        UserProfile user2 = new UserProfile("bob", "password456");

        // Assigning parking passes and fines
        ParkingPass pass1 = new ParkingPass("Pass123", "Lot A");
        ParkingPass pass2 = new ParkingPass("Pass456", "Lot B");
        Fine fine1 = new Fine("Fine001", 50.00);
        Fine fine2 = new Fine("Fine002", 25.00);

        employee.assignParkingPass(user1, pass1);
        employee.assignParkingPass(user1, pass2);
        employee.assignFine(user1, fine1);

        employee.assignParkingPass(user2, pass1);
        employee.assignFine(user2, fine2);

        // Viewing users' fines
        employee.viewUserFines();

        // Assigning parking passes and fines to users
        System.out.println("\n=== Assigning Parking Passes and Fines ===");
        System.out.print("Enter username to assign: ");
        String username = scanner.nextLine(); // Capturing user input
        System.out.print("Enter pass number to assign: ");
        String passNumber = scanner.nextLine();
        System.out.print("Enter parking lot for pass: ");
        String parkingLot = scanner.nextLine();
        System.out.print("Enter fine number to assign: ");
        String fineNumber = scanner.nextLine();
        System.out.print("Enter fine amount: ");
        double fineAmount = scanner.nextDouble();

        ParkingPass newPass = new ParkingPass(passNumber, parkingLot);
        Fine newFine = new Fine(fineNumber, fineAmount);

        employee.assignParkingPass(user1, newPass);
        employee.assignFine(user1, newFine);

        System.out.println("\n=== Updated Users' Fines ===");
        employee.viewUserFines();

        // Example usage of the username variable
        System.out.println("Last assigned parking pass and fine assigned to user: " + username);

        scanner.close();
    }
}
