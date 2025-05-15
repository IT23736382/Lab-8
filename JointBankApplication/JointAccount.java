public class JointAccount {
    private double balance;

    public JointAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("[%s] Deposited: $%.2f | New Balance: $%.2f\n", 
                              Thread.currentThread().getName(), amount, balance);
        }
    }

    public synchronized void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException(amount);
        } else {
            balance -= amount;
            System.out.printf("[%s] Withdrawn: $%.2f | New Balance: $%.2f\n", 
                              Thread.currentThread().getName(), amount, balance);
        }
    }

    public synchronized double getBalance() {
        return balance;
    }
}
