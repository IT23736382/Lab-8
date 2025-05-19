public class JointAccountDemo {
    public static void main(String[] args) {
        JointAccount jointAccount = new JointAccount(1000.0);

        Thread user1 = new Thread(new UserTask(jointAccount), "User-1");
        Thread user2 = new Thread(new UserTask(jointAccount), "User-2");
        Thread user3 = new Thread(new UserTask(jointAccount), "User-3");

        user1.start();
        user2.start();
        user3.start();

        try {
            user1.join();
            user2.join();
            user3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.printf("\nFinal Balance in Joint Account: $%.2f\n", jointAccount.getBalance());
    }
}
