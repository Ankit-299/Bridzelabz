import java.util.InputMismatchException;
import java.util.Scanner;

public class BankingApp {
    private double balance;

    public BankingApp(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        balance += amount;
        System.out.println("Deposit successful. New balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds.");
        }
        balance -= amount;
        System.out.println("Withdrawal successful. New balance: " + balance);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double initialBalance = 0;
        try {
            System.out.print("Enter initial balance: ");
            initialBalance = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            return;
        }

        BankingApp account = new BankingApp(initialBalance);

        while (true) {
            System.out.println("\n1. Deposit\n2. Withdraw\n3. Check Balance\n4. Exit");
            System.out.print("Enter your choice: ");
            int choice = 0;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice. Please enter a number from 1-4.");
                scanner.next();
                continue;
            }

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid amount.");
                        scanner.next();
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        account.withdraw(withdrawAmount);
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid amount.");
                        scanner.next();
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Current balance: " + account.balance);
                    break;
                case 4:
                    System.out.println("Exiting application.");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }
}
