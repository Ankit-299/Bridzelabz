private final String accountNumber;
private String accountHolderName;
private double balance;

public BankAccount(String accountHolderName, String accountNumber, double initialDeposit) {
    this.accountHolderName = accountHolderName;
    this.accountNumber = accountNumber;
    this.balance = initialDeposit;
    totalAccounts++;
}

public static void getTotalAccounts() {
    System.out.println("Total accounts in " + bankName + ": " + totalAccounts);
}

public static String getBankName() {
    return bankName;
}

public static void setBankName(String newName) {
    bankName = newName;
}

public String getAccountHolderName() {
    return accountHolderName;
}

public double getBalance() {
    return balance;
}

public String getAccountNumber() {
    return accountNumber;
}

public void deposit(double amount) {
    if (amount > 0) balance += amount;
}

public boolean withdraw(double amount) {
    if (amount > 0 && amount <= balance) {
        balance -= amount;
        return true;
    }
    return false;
}

@Override
public String toString() {
    return "BankAccount {" +
           "bankName='" + bankName + '\'' +
           ", accountHolderName='" + accountHolderName + '\'' +
           ", accountNumber='" + accountNumber + '\'' +
           ", balance=" + balance +
           '}';
}

public static void displayIfBankAccount(Object obj) {
    if (obj instanceof BankAccount) {
        BankAccount acc = (BankAccount) obj;
        System.out.println(acc.toString());
    } else {
        System.out.println("Provided object is not a BankAccount.");
    }
}

public static void main(String[] args) {
    BankAccount a1 = new BankAccount("Alice", "ACC1001", 500.0);
    BankAccount a2 = new BankAccount("Bob", "ACC1002", 1500.0);

    BankAccount.getTotalAccounts();

    a1.deposit(200);
    a2.withdraw(300);

    BankAccount.displayIfBankAccount(a1);
    BankAccount.displayIfBankAccount("Not an account");

    BankAccount.setBankName("Global Trust Bank");
    System.out.println("After renaming bank:");
    BankAccount.displayIfBankAccount(a2);

    BankAccount.getTotalAccounts();
}
}
