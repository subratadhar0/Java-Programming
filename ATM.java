import java.util.Scanner;

class ATM {
    private int userId;
    private int userPin;
    private double balance;
    private StringBuilder transactionHistory;

    public ATM(int userId, int userPin) {
        this.userId = userId;
        this.userPin = userPin;
        this.balance = 0.0;
        this.transactionHistory = new StringBuilder();
    }

    public boolean authenticate(int userId, int userPin) {
        return this.userId == userId && this.userPin == userPin;
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM!");
        System.out.println("1. Transactions History");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Transfer");
        System.out.println("5. Quit");
    }

    public void showTransactionHistory() {
        System.out.println("Transaction History:");
        System.out.println(transactionHistory.toString());
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            transactionHistory.append("Withdraw: -$").append(amount).append("\n");
            System.out.println("Withdrawal successful. Current balance: $" + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.append("Deposit: +$").append(amount).append("\n");
            System.out.println("Deposit successful. Current balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void transfer(double amount, int recipientUserId) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            transactionHistory.append("Transfer: -$").append(amount).append(" to UserID: ").append(recipientUserId).append("\n");
            System.out.println("Transfer successful. Current balance: $" + balance);
        } else {
            System.out.println("Invalid transfer amount or insufficient balance.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create an ATM instance
        ATM atm = new ATM(123456, 1234);

        // Prompt user for user id and user pin
        System.out.print("Enter user ID: ");
        int userId = scanner.nextInt();

        System.out.print("Enter user PIN: ");
        int userPin = scanner.nextInt();

        // Authenticate user
        if (atm.authenticate(userId, userPin)) {
            boolean quit = false;

            while (!quit) {
                atm.displayMenu();
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        atm.showTransactionHistory();
                        break;
                    case 2:
                        System.out.print("Enter withdrawal amount: $");
                        double withdrawAmount = scanner.nextDouble();
                        atm.withdraw(withdrawAmount);
                        break;
                    case 3:
                        System.out.print("Enter deposit amount: $");
                        double depositAmount = scanner.nextDouble();
                        atm.deposit(depositAmount);
                        break;
                    case 4:
                        System.out.print("Enter transfer amount: $");
                        double transferAmount = scanner.nextDouble();
                        System.out.print("Enter recipient user ID: ");
                        int recipientUserId = scanner.nextInt();
                        atm.transfer(transferAmount, recipientUserId);
                        break;
                    case 5:
                        quit = true;
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }
        } else {
            System.out.println("Invalid user ID or PIN. Access denied.");
        }

        scanner.close();
    }
}
