import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public interface ATM {

    void start();

    void quit();

    public static void main(String[] args) {
        ATM atm = new ATMImpl();
        atm.start();
    }
}

class ATMImpl implements ATM {

    private Scanner scanner;
    private Withdraw withdraw;
    private Deposit deposit;
    private TransactionHistory transactionHistory;
    private Transfer transfer;
    private Map<String, String> userCredentials;

    public ATMImpl() {
        scanner = new Scanner(System.in);
        withdraw = new Withdraw();
        deposit = new Deposit();
        transactionHistory = new TransactionHistory();
        transfer = new Transfer();
        userCredentials = new HashMap<>();
        userCredentials.put("user1", "1234");
        userCredentials.put("user2", "5678");
    }

    @Override
    public void start() {
        // Prompt for user id and pin
        System.out.println("Enter user id: ");
        String userId = scanner.nextLine();

        System.out.println("Enter user pin: ");
        String userPin = scanner.nextLine();

        // Authenticate user
        if (authenticateUser(userId, userPin)) {
            // If authentication successful, display menu
            displayMenu();

            // Perform selected operation
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    withdraw.performOperation();
                    break;
                case 2:
                    deposit.performOperation();
                    break;
                case 3:
                    transactionHistory.performOperation();
                    break;
                case 4:
                    transfer.performOperation();
                    break;
                case 5:
                    quit();
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } else {
            System.out.println("Authentication failed. Invalid user id or pin.");
        }
    }

    private boolean authenticateUser(String userId, String userPin) {
        // Check if user credentials are valid
        return userCredentials.containsKey(userId) && userCredentials.get(userId).equals(userPin);
    }

    private void displayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Transaction History");
        System.out.println("4. Transfer");
        System.out.println("5. Quit");
        System.out.println("Enter your choice: ");
    }

    @Override
    public void quit() {
        System.out.println("Quitting ATM");
    }
}

class Withdraw {
    public void performOperation() {
        // Implementation for withdraw operation
        System.out.println("Withdraw operation");
    }
}

class Deposit {
    public void performOperation() {
        // Implementation for deposit operation
        System.out.println("Deposit operation");
    }
}

class TransactionHistory {
    public void performOperation() {
        // Implementation for transaction history operation
        System.out.println("Transaction history");
    }
}

class Transfer {
    public void performOperation() {
        // Implementation for transfer operation
        System.out.println("Transfer operation");
    }
}