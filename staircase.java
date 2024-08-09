public class staircase {
    public static void main(String[] args) {
        int n = 6;
        for (int i = 1; i <= n; i++)
         {
            for (int p = 1; p <= n-i; p++) {
                System.out.print(" ");

            }
            for (int p = 1; p <= i; p++) {
                System.out.print("#");
            }
            System.out.println();
        }
        
}
}
