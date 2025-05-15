import java.util.Scanner;

public class BankDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account account = new Account("12345", 1000.0);

        System.out.println("Welcome to the Bank Application");
        account.displayBalance();

        System.out.println("Choose transaction: 1 - Withdraw, 2 - Deposit");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter withdrawal amount: $");
                double withdrawAmount = scanner.nextDouble();
                try {
                    account.withdraw(withdrawAmount);
                } catch (InsufficientBalanceException e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 2:
                System.out.print("Enter deposit amount: $");
                double depositAmount = scanner.nextDouble();
                account.deposit(depositAmount);
                break;

            default:
                System.out.println("Invalid choice. Please select 1 or 2.");
        }

        account.displayBalance();
        scanner.close();
    }
}
