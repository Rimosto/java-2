import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SystechRestaurant {
    private static final String DEFAULT_PASSWORD = "Admin123";
    private static final int MAX_LOGIN_ATTEMPTS = 3;

    private static List<Menuitem> menuItems = new ArrayList<>();
    private static List<Menuitem> selectedItems = new ArrayList<>();

    public static void main(String[] args) {
        // Initialize menu items
        menuItems.add(new Menuitem("CHAI", 15));
        menuItems.add(new Menuitem("ANDAZI", 10));
        menuItems.add(new Menuitem("T0STI", 12));
        menuItems.add(new Menuitem("NDENGU AND ACCOMPLISHMENTS", 70));
        menuItems.add(new Menuitem("BEANS AND ACCOMP LISHI'4ENTS", 70));
        menuItems.add(new Menuitem("PILAU VEG", 90));
        menuItems.add(new Menuitem("guit", 100));

        // Login
        boolean isLoggedIn = false;
        int loginAttempts = 0;
        try (Scanner scanner = new Scanner(System.in)) {
            while (!isLoggedIn && loginAttempts < MAX_LOGIN_ATTEMPTS) {
                System.out.print("Enter password: ");
                String password = scanner.nextLine();
                if (password.equals(DEFAULT_PASSWORD)) {
                    isLoggedIn = true;
                } else {
                    loginAttempts++;
                    System.out.println("Invalid password. Try again.");
                }
            }

            if (isLoggedIn) {
                System.out.println("Successful login!");
                displayMenu();
                while (true) {
                    System.out.print("Enter Your Meal/Drink option: ");
                    int option = scanner.nextInt();
                    scanner.nextLine(); // Consume newline left-over
                    Menuitem selectedItem = menuItems.get(option - 1);
                    selectedItems.add(selectedItem);
                    System.out.print("Do you want to enter another meal/drink option? (Y/N): ");
                    String response = scanner.nextLine();
                    if (response.equalsIgnoreCase("N")) {
                        break;
                    }
                }

                System.out.print("Proceed to Payment? (Y/N): ");
                String response = scanner.nextLine();
                if (response.equalsIgnoreCase("Y")) {
                    displayOrderSummary();
                    System.out.print("Enter amount to Pay: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline left-over
                    double balance = calculateBalance(amount);
                    System.out.println("Your Balance is: " + balance);
                }
            } else {
                System.out.println("Maximum login attempts exceeded.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("SYSTECH RESTAURANT:");
        System.out.println("DRINKS");
        for (int i = 0; i < menuItems.size(); i++) {
            Menuitem item = menuItems.get(i);
            System.out.println((i + 1) + ". " + item.getName() + " " + item.getPrice());
        }
    }

    private static void displayOrderSummary() {
        System.out.println("Pay Now For:");
        double total = 0;
        for (Menuitem item : selectedItems) {
            System.out.println(item.getName() + " " + item.getPrice());
            total += item.getPrice();
        }
        System.out.println("Total: " + total);
    }

    private static double calculateBalance(double amount) {
        double total = 0;
        for (Menuitem item : selectedItems) {
            total += item.getPrice();
        }
        return amount - total;
    }

    private static class Menuitem {
        private String name;
        private double price;

        public Menuitem(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
    }
}