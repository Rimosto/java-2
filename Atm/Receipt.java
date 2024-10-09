import java.util.InputMismatchException;
import java.util.Scanner;

// Item Class
class Item {
    String code;
    int quantity;
    double unitPrice;

    public Item(String code, int quantity, double unitPrice) {
        this.code = code;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    // Method that calculates the total value of the item
    public double getTotalValue() {
        return quantity * unitPrice;
    }
}

// POS System Class
public class Receipt {
    private static final String PASSWORD = "Admin123";
    private static final int MAX_LOGIN_ATTEMPTS = 3;
    private static final int MAX_ITEMS = 100;
    private static final Scanner scanner = new Scanner(System.in);

    private Item[] items = new Item[MAX_ITEMS];
    private int itemCount = 0;
    private double totalDue = 0.0;

    public static void main(String[] args) {
        Receipt posSystem = new Receipt();
        posSystem.login();
        posSystem.mainMenu();
    }

    private void login() {
        int attempts = 0;
        while (attempts < MAX_LOGIN_ATTEMPTS) {
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            if (password.equals(PASSWORD)) {
                System.out.println("Login successful!");
                return;
            } else {
                attempts++;
                System.out.println("Invalid password. Try again.");
            }
        }
        System.out.println("Maximum login attempts exceeded.");
        System.exit(0); // Exit the system if maximum attempts are reached
    }

    private void mainMenu() {
        while (true) {
            System.out.println("\nSYSTECH MALL SYSTEM");
            System.out.println("1. ADD ITEM");
            System.out.println("2. MAKE PAYMENT");
            System.out.println("3. DISPLAY RECEIPT");
            System.out.println("4. EXIT");
            System.out.print("Choose an option: ");
            try {
                int option = scanner.nextInt();
                scanner.nextLine(); // consume newline
                switch (option) {
                    case 1:
                        handleAddItem();
                        break;
                    case 2:
                        handleMakePayment();
                        break;
                    case 3:
                        displayReceipt();
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid option. Try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // consume invalid input
            }
        }
    }

    private void handleAddItem() {
        while (itemCount < MAX_ITEMS) {
            System.out.print("Enter item code: ");
            String code = scanner.nextLine();
            int quantity = inputInt("Enter quantity: ");
            double unitPrice = inputDouble("Enter unit price: ");

            Item item = new Item(code, quantity, unitPrice);
            items[itemCount++] = item;

            System.out.print("Do you want to add another item? (Y/N): ");
            char response = scanner.next().charAt(0);
            scanner.nextLine(); // consume newline
            if (response == 'N' || response == 'n') {
                break;
            }
        }
        if (itemCount >= MAX_ITEMS) {
            System.out.println("Maximum items reached.");
        }
    }

    private void handleMakePayment() {
        calculateTotalDue();
        displayItems();

        double amountGiven = inputDouble("Enter amount given by customer: ");
        if (amountGiven < totalDue) {
            System.out.println("Insufficient amount. Payment failed.");
        } else {
            double change = amountGiven - totalDue;
            System.out.printf("Change: %.2f\n", change);
            System.out.println("THANK YOU FOR SHOPPING WITH US!");
        }
    }

    private void calculateTotalDue() {
        totalDue = 0.0;
        for (int i = 0; i < itemCount; i++) {
            totalDue += items[i].getTotalValue();
        }
    }

    private void displayItems() {
        System.out.println("Item Code\tQuantity\tUnit Price\tTotal Value");
        for (int i = 0; i < itemCount; i++) {
            Item item = items[i];
            System.out.printf("%s\t%d\t%.2f\t%.2f\n", item.code, item.quantity, item.unitPrice, item.getTotalValue());
        }
        System.out.printf("Total: %.2f\n", totalDue);
    }

    private void displayReceipt() {
        StringBuilder receipt = new StringBuilder();

        // Header
        receipt.append("========================================\n");
        receipt.append("           SYSTECH MALL SYSTEM          \n");
        receipt.append("              SALES RECEIPT             \n");
        receipt.append("========================================\n");
        receipt.append(
                String.format("%-10s %-10s %-10s %-10s\n", "Item Code", "Quantity", "Unit Price", "Total Value"));
        receipt.append("----------------------------------------\n");

        // Items
        for (int i = 0; i < itemCount; i++) {
            Item item = items[i];
            receipt.append(String.format("%-10s %-10d %-10.2f %-10.2f\n", item.code, item.quantity, item.unitPrice,
                    item.getTotalValue()));
        }
        receipt.append("----------------------------------------\n");

        // Total
        receipt.append(String.format("%-30s %-10.2f\n", "Total Due:", totalDue));

        // Footer
        receipt.append("========================================\n");
        receipt.append("      THANK YOU FOR SHOPPING WITH US!   \n");
        receipt.append("========================================\n");

        // Print the receipt
        System.out.println(receipt.toString());
    }

    // Helper methods for input validation
    private int inputInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // consume invalid input
            }
        }
    }

    private double inputDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // consume invalid input
            }
        }
    }
}
