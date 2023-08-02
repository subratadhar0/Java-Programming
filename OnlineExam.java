import java.util.Scanner;

class OnlineExam {
    private String username;
    private String password;
    private boolean isLoggedIn;

    public OnlineExam() {
        this.username = "";
        this.password = "";
        this.isLoggedIn = false;
    }

    public boolean login(String username, String password) {
        // Here, you would typically validate the username and password against a database or user records
        // For simplicity, we are using fixed values
        if (username.equals("admin") && password.equals("admin123")) {
            this.username = username;
            this.password = password;
            this.isLoggedIn = true;
            return true;
        }
        return false;
    }

    public void updateProfile(String newUsername, String newPassword) {
        if (isLoggedIn) {
            this.username = newUsername;
            this.password = newPassword;
            System.out.println("Profile updated successfully!");
        } else {
            System.out.println("Please log in first to update your profile.");
        }
    }

    public void startExam() {
        if (isLoggedIn) {
            System.out.println("Exam started. You have 30 minutes to complete the exam.");
            // Place your code here for the exam questions and logic
            // You can add MCQs, timer, auto-submit, etc.
            // This is just a placeholder message for simplicity
            System.out.println("Exam completed. Thank you!");
        } else {
            System.out.println("Please log in first to start the exam.");
        }
    }

    public void logout() {
        if (isLoggedIn) {
            this.username = "";
            this.password = "";
            this.isLoggedIn = false;
            System.out.println("Logged out successfully!");
        } else {
            System.out.println("You are not currently logged in.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create an OnlineExam instance
        OnlineExam onlineExam = new OnlineExam();

        boolean quit = false;

        while (!quit) {
            System.out.println("=== Online Examination System ===");
            System.out.println("1. Login");
            System.out.println("2. Update Profile");
            System.out.println("3. Start Exam");
            System.out.println("4. Logout");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    if (onlineExam.login(username, password)) {
                        System.out.println("Logged in successfully!");
                    } else {
                        System.out.println("Invalid username or password. Login failed.");
                    }
                    break;
                case 2:
                    if (onlineExam.isLoggedIn) {
                        System.out.print("Enter new username: ");
                        String newUsername = scanner.nextLine();
                        System.out.print("Enter new password: ");
                        String newPassword = scanner.nextLine();
                        onlineExam.updateProfile(newUsername, newPassword);
                    } else {
                        System.out.println("Please log in first to update your profile.");
                    }
                    break;
                case 3:
                    onlineExam.startExam();
                    break;
                case 4:
                    onlineExam.logout();
                    break;
                case 5:
                    quit = true;
                    System.out.println("Thank you for using the Online Examination System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}
