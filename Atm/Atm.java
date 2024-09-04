import java.util.Scanner;

public class Atm {
    private static final String DEFAULT_PASSWORD = "Admin123";
    private static final int ATTEMPTS = 3;
    private static final double INITIAL_BALANCE = 25.00;
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
                System.out.println("incorrect password please confirm and try again. Exiting...");
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
                        showBalance();
                        break;
                    case 2:
                        depositnow();
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
                        TransferCash();
                        break;
                    case 5:
                        Exiting();
                        return;
                    default:
                        option();
                }
            }
        }
    }

    public static final void showBalance() {
        System.out.println("Your balance is: Ksh " + INITIAL_BALANCE);
    }

    public static final void depositnow() {
        System.out.println("Deposit successful. New balance: Ksh " + INITIAL_BALANCE);
    }
    public static final void TransferCash(){
        System.out.println("Transfer cash option not implemented.");
    }
    public static final void Exiting(){
        System.out.println("Exiting...");
    }
    public static final void option(){
        System.out.println("invalid option: ");
    }
}