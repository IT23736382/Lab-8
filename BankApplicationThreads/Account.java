public class Account {
    private String accountNumber;
    private double balance;

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public synchronized void displayBalance() {
        System.out.println("Account Number: " + accountNumber);
        System.out.printf("Current Balance: $%.2f\n", balance);
    }

    public synchronized void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Deposited: $%.2f\n", amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public synchronized void withdraw(double amount) throws InsufficientBalanceException {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
        } else if (amount > balance) {
            throw new InsufficientBalanceException(amount, balance);
        } else {
            balance -= amount;
            System.out.printf("Withdrawn: $%.2f\n", amount);
        }
    }
}
