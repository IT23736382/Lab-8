import java.util.Scanner;

public class BankDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account account = new Account("12345", 1000.0);

        System.out.println("Welcome to the Bank Application");

        boolean continueTransaction = true;

        while (continueTransaction) {
            boolean success = false;
            double lastWithdrawnAmount = 0;

            account.displayBalance(); // Show balance at the beginning of each loop

            System.out.println("\nChoose transaction: 1 - Withdraw, 2 - Deposit");
            int choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter withdrawal amount: $");
                        double withdrawAmount = scanner.nextDouble();
                        account.withdraw(withdrawAmount);
                        success = true;
                        lastWithdrawnAmount = withdrawAmount;
                        break;

                    case 2:
                        System.out.print("Enter deposit amount: $");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                        break;

                    default:
                        System.out.println("Invalid choice. Please select 1 or 2.");
                }
            } catch (InsufficientBalanceException e) {
                System.out.println(e.getMessage());
            } finally {
                account.displayBalance(); // Show updated balance after transaction
                System.out.print("Do you wish to continue? (yes/no): ");
                scanner.nextLine(); // Consume leftover newline
                String response = scanner.nextLine().trim().toLowerCase();

                if (!response.equals("yes")) {
                    continueTransaction = false;
                    System.out.println("Thank you for using our service!");
                } else {
                    if (success && choice == 1) {
                        account.deposit(lastWithdrawnAmount); // restore withdrawn amount
                        System.out.println("Amount redeposited for retry.");
                    }
                }
            }
        }

        scanner.close();
    }
}
