public class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(double amount, double balance) {
        super("Error: Insufficient balance. You tried to withdraw $" + amount + ", but only $" + balance + " is available.");
    }
}
