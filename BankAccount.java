
import java.util.Scanner;

class Account {
    private double balance;

    // Constructor
    public Account(double balance) {
        this.balance = balance;
    }

    // Deposit Money
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount!");
            return;
        }

        balance += amount;
        System.out.println("Money deposited successfully!");
    }

    // Withdraw Money
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount!");
            return;
        }

        if (amount > balance) {
            throw new IllegalArgumentException(
                "Insufficient balance!"
            );
        }

        balance -= amount;
        System.out.println("Money withdrawn successfully!");
    }

    // Check Balance
    public double getBalance() {
        return balance;
    }
}

// Main Class
public class BankAccount {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Account account = new Account(1000);

        while (true) {

            System.out.println("\n===== BANK ACCOUNT SYSTEM =====");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");

            int choice;

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
                continue;
            }

            switch (choice) {

                case 1:
                    System.out.print("Enter deposit amount: ");

                    try {
                        double deposit = Double.parseDouble(sc.nextLine());
                        account.deposit(deposit);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid amount!");
                    }
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: ");

                    try {
                        double withdraw = Double.parseDouble(sc.nextLine());
                        account.withdraw(withdraw);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid amount!");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println(
                        "Current Balance: " + account.getBalance()
                    );
                    break;

                case 4:
                    System.out.println("Thank you for using our Bank System!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
