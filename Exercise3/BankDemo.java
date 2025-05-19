public class BankDemo {
    public static void main(String[] args) {
        Account sharedAccount = new Account("12345", 1000.0);

        Thread user1 = new Thread(new BankTask(sharedAccount, "User-1"));
        Thread user2 = new Thread(new BankTask(sharedAccount, "User-2"));
        Thread user3 = new Thread(new BankTask(sharedAccount, "User-3"));

        System.out.println("Starting multithreaded transactions...\n");

        user1.start();
        user2.start();
        user3.start();

        try {
            user1.join();
            user2.join();
            user3.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }

        System.out.println("Final Balance After All Transactions:");
        sharedAccount.displayBalance();
    }
}
