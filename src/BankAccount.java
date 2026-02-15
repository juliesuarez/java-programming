public class BankAccount {
    // Static variable: Shared by all accounts
    private static double annualInterestRate = 0.03;

    // Instance variable: Unique to each account
    private double balance;
    private String ownerName;

    public BankAccount(String name, double initialBalance) {
        this.ownerName = name;
        this.balance = initialBalance;
    }

    // Static method: Operates on class-level data
    public static void setInterestRate(double newRate) {
        annualInterestRate = newRate;
    }

    // Non-static (Instance) method: Operates on object-level data
    public void applyInterest() {
        // Can access both static (interestRate) and instance (balance) variables
        double interest = this.balance * annualInterestRate;
        this.balance += interest;
    }
}