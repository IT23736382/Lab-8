import java.util.Random;

public class BankTask implements Runnable {
    private Account account;
    private String userName;
    private Random random = new Random();

    public BankTask(Account account, String userName) {
        this.account = account;
        this.userName = userName;
    }

    @Override
    public void run() {
        try {
            double amount = 50 + random.nextInt(200); 
            boolean isDeposit = random.nextBoolean();

            synchronized (account) {
                System.out.println("[" + userName + "] Starting transaction...");

                if (isDeposit) {
                    System.out.println("[" + userName + "] Depositing $" + amount);
                    account.deposit(amount);
                } else {
                    System.out.println("[" + userName + "] Attempting to withdraw $" + amount);
                    account.withdraw(amount);
                }

                account.displayBalance();
                System.out.println("[" + userName + "] Transaction completed.\n");
            }
        } catch (InsufficientBalanceException e) {
            System.out.println("[" + userName + "] " + e.getMessage());
        }
    }
}
