// Superclass / Abstract Class
abstract class BankAccount {
    private String accountNumber;
    protected double balance; // protected so subclasses can access safely

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Getter
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    // Common method (final - subclasses should not override this)
    public final void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " deposited. New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    // Abstract method (must be implemented by subclasses)
    public abstract void displayAccountType();
}

// Subclass 1: Savings Account
class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void displayAccountType() {
        System.out.println("Account Type: Savings Account");
        System.out.println("Interest Rate: " + interestRate + "%");
    }

    public void addInterest() {
        double interest = balance * (interestRate / 100);
        balance += interest;
        System.out.println("Interest added: " + interest + ". New Balance: " + balance);
    }
}

// Subclass 2: Checking Account
class CheckingAccount extends BankAccount {
    private int withdrawalLimit;

    public CheckingAccount(String accountNumber, double balance, int withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    @Override
    public void displayAccountType() {
        System.out.println("Account Type: Checking Account");
        System.out.println("Withdrawal Limit: " + withdrawalLimit);
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance && withdrawalLimit > 0) {
            balance -= amount;
            withdrawalLimit--;
            System.out.println(amount + " withdrawn. New balance: " + balance +
                               " | Remaining limit: " + withdrawalLimit);
        } else {
            System.out.println("Withdrawal failed. Check balance or limit.");
        }
    }
}

// Subclass 3: Fixed Deposit Account
class FixedDepositAccount extends BankAccount {
    private int lockInPeriod; // months

    public FixedDepositAccount(String accountNumber, double balance, int lockInPeriod) {
        super(accountNumber, balance);
        this.lockInPeriod = lockInPeriod;
    }

    @Override
    public void displayAccountType() {
        System.out.println("Account Type: Fixed Deposit Account");
        System.out.println("Lock-in Period: " + lockInPeriod + " months");
    }
}

// Main Class
public class BankSystem {
    public static void main(String[] args) {
        BankAccount acc1 = new SavingsAccount("SA123", 1000, 5.0);
        BankAccount acc2 = new CheckingAccount("CA456", 2000, 3);
        BankAccount acc3 = new FixedDepositAccount("FD789", 5000, 12);

        acc1.displayAccountType();
        ((SavingsAccount) acc1).addInterest();

        acc2.displayAccountType();
        ((CheckingAccount) acc2).withdraw(500);

        acc3.displayAccountType();
    }
}
