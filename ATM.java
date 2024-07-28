import java.util.Scanner;

// Class to represent the user's bank account
class BankAccount {
    private double balance;

    // Constructor to initialize the account with a given balance
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to deposit an amount
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw an amount
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew $" + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }

    // Method to check the balance
    public double checkBalance() {
        return balance;
    }
}

// Class to represent the ATM machine
public class ATM {
    private BankAccount account;

    // Constructor to initialize the ATM with a user's bank account
    public ATM(BankAccount account) {
        this.account = account;
    }

    // Method to display the ATM menu and process user input
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    withdraw(withdrawalAmount);
                    break;
                case 4:
                    exit = true;
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    // Method to check the balance
    public void checkBalance() {
        System.out.println("Your current balance is: $" + account.checkBalance());
    }

    // Method to deposit an amount
    public void deposit(double amount) {
        account.deposit(amount);
    }

    // Method to withdraw an amount
    public void withdraw(double amount) {
        account.withdraw(amount);
    }

    // Main method to run the ATM program
    public static void main(String[] args) {
        // Initialize a bank account with a starting balance
        BankAccount userAccount = new BankAccount(1000.0);

        // Create an ATM instance with the user's bank account
        ATM atm = new ATM(userAccount);

        // Display the ATM menu
        atm.displayMenu();
    }
}
