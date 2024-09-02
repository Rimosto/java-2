import java.util.Scanner;

public class Atm {
    private static final String DEFAULT_PASSWORD = "Admin123";
    private static final int ATTEMPTS = 3;
    private static final double INITIAL_BALANCE = 10001000.00;
    private static final double WITHDRAWAL_CHARGE = 0.02;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int Attempts = 0;
            boolean LoggedIn = false;
            double balance = INITIAL_BALANCE;

            while (!LoggedIn && Attempts < ATTEMPTS) {
                System.out.print("Enter password: ");
                String password = scanner.nextLine();
                if (password.equals(DEFAULT_PASSWORD)) {
                    LoggedIn = true;
                } else {
                    Attempts++;
                    System.out.println("Incorrect password. Attempts remaining: " + (ATTEMPTS - Attempts));
                }
            }

            if (!LoggedIn) {
                System.out.println("Maximum login attempts exceeded. Exiting...");
                return;
            }

            while (true) {
                System.out.println("ATM SERVICES");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Transfer Cash");
                System.out.println("5. Quit");
                System.out.print("Choose your option: ");
                int option = scanner.nextInt();
                scanner.nextLine();
                switch (option) {
                    case 1:
                        System.out.println("Your balance is: Ksh " + balance);
                        break;
                    case 2:
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        scanner.nextLine(); 
                        balance += depositAmount;
                        System.out.println("Deposit successful. New balance: Ksh " + balance);
                        break;
                    case 3:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        scanner.nextLine(); 
                        if (withdrawAmount > balance) {
                            System.out.println("Insufficient balance.");
                        } else {
                            double withdrawalCharge = withdrawAmount * WITHDRAWAL_CHARGE;
                            balance -= withdrawAmount + withdrawalCharge;
                            System.out.println("Withdrawal successful. New balance: Ksh " + balance);
                        }
                        break;
                    case 4:
                        System.out.println("Transfer cash option not implemented.");
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid option. Please choose a valid option.");
                }
            }
        }
    }
}