import java.util.Scanner;

public class Oop {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("ENTER YOUR NAME: ");
            String name = scanner.nextLine();
            
            System.out.print("ENTER YOUR AGE: ");
            int age = scanner.nextInt();
            System.out.println("Hello, " + name + " you are " + age + " years");
        }

    }
}