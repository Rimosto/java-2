
public class Variables{

    public static void main(String[] args) {
        String name = "Patrick Rimomo";
        System.out.println("MY NAME IS: " + name);
        int a = 1;
        int b = 2;
        boolean c = a == b;
        System.out.println(a + b);
        System.out.println(a * b);
        System.out.println(a / b);
        System.out.println(a % b);
        System.out.println(a - b);
        System.out.println(a += b);
        System.out.println(a -= b);
        System.out.println(a /= b);
        System.out.println(a *= b);
        System.out.println(a %= b);
        System.out.println(c);

        if (a < b) {
            System.out.println("this is great");
        } else if (a > b) {
            System.out.println("impossible");
        } else if (a <= b) {
            System.out.println("possible");
        } else {
            System.out.println("this is not great");
        }
        for (int i = 1; i <= 10; i++) {
            if (i == 4) {
                break;
            }
            System.out.println(i);
        }
        int Length = name.length();
        System.out.println("name length: " + Length);
        String Name = name.toUpperCase();
        System.out.println(Name);
        String None = name.toLowerCase();
        System.out.println(None);
        boolean comp = name.equals(Name);
        System.out.println(comp);
        boolean compa = name.equalsIgnoreCase(Name);
        System.out.println(compa);
        int j = 2;
        do {
            for (int p = 0; p < 10; p++) {
                if(p==5){
                break;
                }
                System.out.println(p);

            }
            System.out.println("am training");
            j++;
        } while (j <= 2);

    }

}