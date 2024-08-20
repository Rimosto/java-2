
import java.util.*;

public class proj
{
public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
        System.out.print("ENTER YOUR NAME: ");
        String name =scanner.nextLine();

        System.out.print("ENTER YOUR YEAR OF BIRTH: ");
        int yearOfBirth = scanner.nextInt();
        
        int currentYear = 2024; 
        int age = currentYear - yearOfBirth;
        if (yearOfBirth > currentYear) {
            System.out.println("Invalid year of birth.");
            return;
        } else if (yearOfBirth <= 1930) {
            System.out.println("Invalid year of birth.");
            return;
        }
        scanner.nextLine();
        System.out.print("ENTER YOUR city: ");
        String city =scanner.nextLine();
        System.out.println("your name is..."+ name +" age is.."+ age +"your city is .."+ city );
    }
}
}
