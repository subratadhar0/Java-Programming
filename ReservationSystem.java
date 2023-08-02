import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class ReservationSystem {
    private Map<String, String> userCredentials;

    public ReservationSystem() {
        this.userCredentials = new HashMap<>();
        // Add some sample user credentials (username, password) for demonstration
        userCredentials.put("user1", "password1");
        userCredentials.put("user2", "password2");
    }

    public boolean login(String username, String password) {
        String storedPassword = userCredentials.get(username);
        return storedPassword != null && storedPassword.equals(password);
    }

    public void makeReservation(String username) {
        System.out.println("Reservation form:");
        // Place your code here for the reservation form and processing
        System.out.println("Reservation successful!");
    }

    public void cancelReservation(String pnrNumber) {
        System.out.println("Cancellation form:");
        // Place your code here for the cancellation form and processing
        System.out.println("Cancellation successful!");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a ReservationSystem instance
        ReservationSystem reservationSystem = new ReservationSystem();

        boolean quit = false;

        while (!quit) {
            System.out.println("=== Online Reservation System ===");
            System.out.println("1. Login");
            System.out.println("2. Make Reservation");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    if (reservationSystem.login(username, password)) {
                        System.out.println("Logged in successfully!");
                    } else {
                        System.out.println("Invalid username or password. Login failed.");
                    }
                    break;
                case 2:
                    System.out.print("Enter your username: ");
                    String reservationUsername = scanner.nextLine();
                    reservationSystem.makeReservation(reservationUsername);
                    break;
                case 3:
                    System.out.print("Enter your PNR number: ");
                    String pnrNumber = scanner.nextLine();
                    reservationSystem.cancelReservation(pnrNumber);
                    break;
                case 4:
                    quit = true;
                    System.out.println("Thank you for using the Online Reservation System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}
