public class diamond {
    public static void main(String[] args) {
        int n = 9;

        // Upper half of the diamond
        for (int i = 1; i <= n; i += 2) {
            int spaces = (n - i) / 2;
            for (int j = 0; j < spaces; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Lower half of the diamond
        for (int i = n - 2; i > 0; i -= 2) {
            int spaces = (n - i) / 2;
            for (int j = 0; j < spaces; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}