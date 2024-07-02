import java.util.Scanner;

class ATM {
    private double balance;
    private String transactionHistory = "";

    public ATM() {
        this.balance = 0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory += "Deposited: " + amount + "\n";
            System.out.println("Successfully deposited " + amount);
        } else {
            System.out.println("Invalid amount. Please enter a positive value.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory += "Withdrew: " + amount + "\n";
            System.out.println("Successfully withdrew " + amount);
        } else {
            System.out.println("Invalid amount or insufficient balance.");
        }
    }

    public void transfer(ATM target, double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            target.balance += amount;
            transactionHistory += "Transferred: " + amount + " to " + target + "\n";
            System.out.println("Successfully transferred " + amount);
        } else {
            System.out.println("Invalid amount or insufficient balance.");
        }
    }

    public void showTransactionHistory() {
        System.out.println("Transaction History:");
        System.out.println(transactionHistory);
    }

    public double getBalance() {
        return balance;
    }
}

public class task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM();
        ATM targetAtm = new ATM(); // Another ATM for transfer demonstration

        System.out.print("Enter user ID: ");
        String userId = scanner.nextLine();

        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();

        if (authenticate(userId, pin)) {
            int option;
            do {
                System.out.println("ATM Menu:");
                System.out.println("1. Transaction History");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Transfer");
                System.out.println("5. Quit");
                System.out.print("Choose an option: ");
                option = scanner.nextInt();

                switch (option) {
                    case 1:
                        atm.showTransactionHistory();
                        break;
                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        atm.withdraw(withdrawAmount);
                        break;
                    case 3:
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        atm.deposit(depositAmount);
                        break;
                    case 4:
                        System.out.print("Enter amount to transfer: ");
                        double transferAmount = scanner.nextDouble();
                        atm.transfer(targetAtm, transferAmount);
                        break;
                    case 5:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } while (option != 5);
        } else {
            System.out.println("Authentication failed. Please try again.");
        }

        scanner.close();
    }

    private static boolean authenticate(String userId, String pin) {
        // For demo purposes, let's assume any non-empty userId and pin are valid
        return !userId.isEmpty() && !pin.isEmpty();
    }
}