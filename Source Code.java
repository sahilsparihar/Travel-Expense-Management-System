import java.util.Scanner;

class Expense {
    private String description;
    private double amount;

    public Expense(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }
}

class ExpenseManager {
    private Expense[] expenses;
    private int count;
    private double totalAmount;

    public ExpenseManager(int capacity) {
        expenses = new Expense[capacity];
        count = 0;
        totalAmount = 0.0;
    }

    public void addExpense(Expense expense) {
        if (count < expenses.length) {
            expenses[count] = expense;
            count++;
            totalAmount += expense.getAmount();
            System.out.println("Expense added successfully.");
        } else {
            System.out.println("Expense manager is full. Cannot add more expenses.");
        }
    }

    public void displayExpenses() {
        if (count == 0) {
            System.out.println("No expenses to display.");
        } else {
            System.out.println("Expenses:");
            for (int i = 0; i < count; i++) {
                Expense expense = expenses[i];
                System.out.println("Description: " + expense.getDescription() + ", Amount: " + expense.getAmount());
            }
            System.out.println("Total Amount: " + totalAmount);
        }
    }
}

public class TravelExpenseManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the capacity of the expense manager: ");
        int capacity = scanner.nextInt();
        scanner.nextLine(); // Consume the remaining newline character

        ExpenseManager expenseManager = new ExpenseManager(capacity);

        while (true) {
            System.out.println("\n1. Add Expense");
            System.out.println("2. Display Expenses");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the remaining newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter expense description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter expense amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); // Consume the remaining newline character

                    Expense expense = new Expense(description, amount);
                    expenseManager.addExpense(expense);
                    break;
                case 2:
                    expenseManager.displayExpenses();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
