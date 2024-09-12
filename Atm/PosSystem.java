import java.time.LocalDateTime;
import java.util.*;

class Item {
    String code;
    int quantity;
    double unitPrice;
    double totalValue;

    public Item(String code, int quantity, double unitPrice) {
        this.code = code;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalValue = quantity * unitPrice;
    }
}

public class PosSystem {
    private static final String PASSWORD = "Admin123";
    private static final int MAX_LOGIN_ATTEMPTS = 3;
    private static final int MAX_ITEMS = 100;

    private Item[] items = new Item[MAX_ITEMS];
    private int itemCount = 0;
    public static double totalDue = 0;
    private Scanner scanner;  // Single Scanner instance for the entire program

    public static void main(String[] args) {
        PosSystem posSystem = new PosSystem();
        try {
            posSystem.scanner = new Scanner(System.in);  // Initialize Scanner
            posSystem.login();
            posSystem.mainMenu();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            posSystem.scanner.close();  // Close the scanner after use
        }
    }

    void login() {
        int attempts = 0;
        while (attempts < MAX_LOGIN_ATTEMPTS) {
            System.out.print("Enter password: ")
            ;
            String password = scanner.nextLine();
            if (password.equals(PASSWORD)) {
                System.out.println("Login successful!");
                return;
            } else {
                attempts++;
                if (attempts < MAX_LOGIN_ATTEMPTS) {
                    System.out.println("Invalid password. Try again.");
                }
            }
        }
    }

    void mainMenu() {
        while (true) {
            System.out.println("SYSTECH MALL SYSTEM");
            System.out.println("1. ADD ITEM");
            System.out.println("2. MAKE PAYMENT");
            System.out.println("3. DISPLAY RECEIPT");
            System.out.println("4. EXIT");
            System.out.print("Choose an option: ");

            try {
                int option = Integer.parseInt(scanner.nextLine());  // Read input as string and parse

                switch (option) {
                    case 1:
                        addItem();
                        break;
                    case 2:
                        makePayment();
                        break;
                    case 3:
                        displayReceipt();
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid option. Please enter a number between 1 and 4.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    private void addItem() {
        while (true) {
            if (itemCount >= MAX_ITEMS) {
                System.out.println("Maximum items reached.");
                return;
            }
            System.out.print("Enter item code: ");
            String code = scanner.next();
            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();
            System.out.print("Enter unit price: ");
            double unitPrice = scanner.nextDouble();
            Item item = new Item(code, quantity, unitPrice);
            items[itemCount++] = item;

            System.out.print("Do you want to add another item? (Y/N): ");
            char response = scanner.next().charAt(0);
            scanner.nextLine();  // Consume newline character
            if (response == 'N') {
                break;
            }
        }
    }

    private void makePayment() {
        totalDue = 0;
        for (int i = 0; i < itemCount; i++) {
            totalDue += items[i].totalValue;
        }
        System.out.printf("Total:\t%.2f\n", totalDue);
        System.out.print("Enter amount given by customer: ");
        double amountGiven = scanner.nextDouble();
        if (amountGiven < totalDue) {
            System.out.println("Insufficient amount given.");
            return;
        }
        else{
        double change = amountGiven - totalDue;
        System.out.printf("Change:\t%.2f\n", change);
        }
    
    }

    private void displayReceipt() {
        totalDue = 0;
        LocalDateTime date = LocalDateTime.now();
        System.out.println("SYSTECH MALL SYSTEM");
        System.out.println("RECEIPT");
        System.out.println("Date: " + date);
        System.out.println("Item Code\tQuantity\tUnit Price\tTotal Value");
        for (int i = 0; i < itemCount; i++) {
            totalDue += items[i].totalValue;
            System.out.printf("%s\t%d\t%.2f\t%.2f\n", items[i].code, items[i].quantity, items[i].unitPrice,
                    items[i].totalValue);
        }
        System.out.printf("Total:\t%.2f\n", totalDue);
        System.out.println("THANK YOU FOR SHOPPING WITH US");
    }
}