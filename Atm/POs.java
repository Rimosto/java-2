import java.util.Scanner;

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

public class POs{
    private static final String PASSWORD = "Admin123";
    private static final int MAX_LOGIN_ATTEMPTS = 3;
    private static final int MAX_ITEMS = 100;

    private Item[] items = new Item[MAX_ITEMS];
    private int itemCount = 0;
    private double totalDue = 0;
    private double change = 0;

    public static void main(String[] args) {
        PosSystem posSystem = new PosSystem();
        posSystem.login();
        posSystem.mainMenu();
    }

    private void login() {
        Scanner scanner = new Scanner(System.in);
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
        System.exit(1);
    }

    private void mainMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("SYSTECH MALL SYSTEM");
            System.out.println("1. ADD ITEM");
            System.out.println("2. MAKE PAYMENT");
            System.out.println("3. DISPLAY RECEIPT");
            System.out.println("4. EXIT");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
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
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private void displayReceipt() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'displayReceipt'");
    }

    private void addItem() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (itemCount >= MAX_ITEMS) {
                System.out.println("Maximum items reached.");
                break;
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
            if (response == 'N' || response == 'n') {
                break;
            }
        }
    }

    private void makePayment() {
        totalDue = 0;
        for (int i = 0; i < itemCount; i++) {
            totalDue += items[i].totalValue;
        }
        System.out.println("Item Code\tQuantity\tUnit Price\tTotal Value");
        for (int i = 0; i < itemCount; i++) {
            System.out.printf(null, items);
        }
    }
}