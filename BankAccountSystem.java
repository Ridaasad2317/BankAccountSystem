import java.util.ArrayList;
import java.util.Scanner;

class BankAccount {
    private String name;
    private long accountNumber;
    private double balance;
    private ArrayList<String> transactions;

    public BankAccount(String name, long accountNumber) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    public void depositMoney(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount!");
            return;
        }
        balance += amount;
        transactions.add("Deposited: " + amount);
        System.out.println("Amount deposited successfully!");
    }

    public void withdrawMoney(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount!");
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            transactions.add("Withdrew: " + amount);
            System.out.println("Transaction successful!");
        }
    }

    public void displayBalance() {
        System.out.println("\nCurrent balance: " + balance);
    }

    public void displayAccountInfo() {
        System.out.println("\n--- Account Info ---");
        System.out.println("Name: " + name);
        System.out.println("Account Number: " + accountNumber);
    }

    public void showTransactions() {
        System.out.println("\n--- Transaction History ---");
        if (transactions.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (String t : transactions) {
                System.out.println(t);
            }
        }
    }

    public String getName() {
        return name;
    }
}

public class BankAccountSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();

        System.out.print("Enter account number: ");
        long accNo = sc.nextLong();
        sc.nextLine(); // FIX: clear buffer

        BankAccount account = new BankAccount(name, accNo);

        int choice = 0;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1) Deposit");
            System.out.println("2) Withdraw");
            System.out.println("3) Check Balance");
            System.out.println("4) Account Info");
            System.out.println("5) Transaction History");
            System.out.println("6) Exit");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Enter a number.");
                sc.nextLine();
                continue;
            }

            choice = sc.nextInt();
            sc.nextLine(); // FIX: clear buffer

            switch (choice) {
            case 1:
            System.out.print("Enter amount to deposit: ");
                if (!sc.hasNextDouble()) {
                    System.out.println("Invalid amount!");
                    sc.nextLine();
                    break;
                    }
            double depositAmount = sc.nextDouble();
            sc.nextLine();
            account.depositMoney(depositAmount);
            break;

            case 2:
            System.out.print("Enter amount to withdraw: ");
                if (!sc.hasNextDouble()) {
                    System.out.println("Invalid amount!");
                    sc.nextLine();
                    break;
                    }
            double withdrawAmount = sc.nextDouble();
            sc.nextLine();
            account.withdrawMoney(withdrawAmount);
            break;

            case 3:
                account.displayBalance();
                break;

            case 4:
                account.displayAccountInfo();
                break;

            case 5:
                account.showTransactions();
                break;

            case 6:
                System.out.println("\nDear " + account.getName() +
                        ", Thank you for using our banking system!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}