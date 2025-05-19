import java.util.Random;

public class UserTask implements Runnable {
    private JointAccount jointAccount;
    private Random random = new Random();

    public UserTask(JointAccount jointAccount) {
        this.jointAccount = jointAccount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) { 
            double amount = random.nextDouble() * 100;
            boolean doWithdraw = random.nextBoolean(); 

            try {
                if (doWithdraw) {
                    jointAccount.withdraw(amount);
                } else {
                    jointAccount.deposit(amount);
                }

                Thread.sleep(random.nextInt(500)); 
            } catch (InsufficientBalanceException e) {
                System.out.printf("[%s] %s\n", Thread.currentThread().getName(), e.getMessage());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
