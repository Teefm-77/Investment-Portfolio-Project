import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Asset> portfolio = new ArrayList<>();
        boolean running = true;

        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Add new asset");
            System.out.println("2. Show portfolio report");
            System.out.println("3. Exit");
            System.out.print("Please select an option (1-3): ");
            
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    addAsset(input, portfolio);
                    break;
                case 2:
                    showReport(portfolio);
                    break;
                case 3:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        input.close();
    }

    public static void addAsset(Scanner input, ArrayList<Asset> portfolio) {
        System.out.println("\nSelect type (1: Stock, 2: Crypto, 3: Cash): ");
        int type = input.nextInt();
        input.nextLine(); 

        System.out.print("Name: "); String name = input.nextLine();
        System.out.print("Symbol: "); String symbol = input.nextLine();

        if (type == 1) {
            System.out.print("Quantity: "); double qty = input.nextDouble();
            System.out.print("Price: "); double price = input.nextDouble();
            System.out.print("Tax rate (e.g., 0.05): "); double tax = input.nextDouble();
            portfolio.add(new Stock(name, symbol, qty, price, tax));
        } else if (type == 2) {
            System.out.print("Quantity: "); double qty = input.nextDouble();
            System.out.print("Price: "); double price = input.nextDouble();
            System.out.print("Tax rate (e.g., 0.10): "); double tax = input.nextDouble();
            portfolio.add(new Crypto(name, symbol, qty, price, tax));
        } else {
            System.out.print("Amount (Cash): "); double balance = input.nextDouble();
            portfolio.add(new Cash(name, symbol, balance));
        }
        System.out.println("Asset added successfully!");
    }

    public static void showReport(ArrayList<Asset> portfolio) {
        double totalValue = 0;
        double totalTax = 0;
        System.out.println("\n--- Portfolio Report ---");
        for (Asset item : portfolio) {
            System.out.println("Asset: " + item.getName() + " | Value: $" + item.calculateValue());
            totalValue += item.calculateValue();
            if (item instanceof Taxable) {
                totalTax += ((Taxable) item).calculateTax();
            }
        }
        System.out.println("---------------------------");
        System.out.println("Total Value: $" + totalValue);
        System.out.println("Total Taxes: $" + totalTax);
    }
}