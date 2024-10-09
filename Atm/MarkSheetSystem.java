
import java.util.*;

class Student {
    String studentNumber;
    int[] marks = new int[5];
    int total;
    double average;
    char grade;

    public Student(String studentNumber, int[] marks) {
        this.studentNumber = studentNumber;
        this.marks = marks;
        this.total = calculateTotal();
        this.average = calculateAverage();
        this.grade = calculateGrade();
    }

    private int calculateTotal() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }

    private double calculateAverage() {
        return total / 5.0;
    }

    private char calculateGrade() {
        if (average >= 70){
            return 'A';
        }
        else if (average >= 60){
            return 'B';
        }
        else if (average >= 50){
            return 'C';
        }
        else if (average >= 40){
            return 'D';
        }
            else{
        return 'F';
    }
}

    @Override
    public String toString() {
        return studentNumber + "\t" + marks[0] + "\t" + marks[1] + "\t" + marks[2] + "\t" + marks[3] + "\t" + marks[4]
                + "\t" + total + "\t" + String.format("%.2f", average) + "\t" + grade;
    }
}

public class MarkSheetSystem {

    static final String DEFAULT_PASSWORD = "Admin123";
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        if (login()) {
            menu();
        } else {
            System.out.println("Login failed. Program exiting.");
        }
    }

    // Login system with three attempts
    public static boolean login() {
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            if (password.equals(DEFAULT_PASSWORD)) {
                System.out.println("Successful login!");
                return true;
            } else {
                System.out.println("Incorrect password. Try again.");
            }
        }
        return false;
    }

    // Main menu
    public static void menu() {
        int choice;
        do {
            System.out.println("\nSYSTECH Mark Sheet System:");
            System.out.println("1. Add marks");
            System.out.println("2. View marks");
            System.out.println("3. Quit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addMarks();
                    break;
                case 2:
                    viewMarks();
                    break;
                case 3:
                    confirmExit();
                    break;
                default:
                    System.out.println("Invalid option, try again.");
            }
        } while (choice != 3);
    }

    // Adding marks for students
    public static void addMarks() {
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter student name: ");
            String studentNumber = scanner.nextLine();

            int[] marks = new int[5];
            for (int j = 0; j < 5; j++) {
                System.out.print("Enter marks for Unit " + (j + 1) + ": ");
                marks[j] = scanner.nextInt();
            }
            System.out.print("Do you want to add a student marks?: ");
            if (scanner.nextLine().equalsIgnoreCase("Y")) {
                menu();
            }
            scanner.nextLine(); 

            students.add(new Student(studentNumber, marks));
        }

       
    }

    // Viewing marks for all students
    public static void viewMarks() {
        if (students.isEmpty()) {
            System.out.println("No marks available to display.");
        } else {
            System.out.println("StudentNo\tUnit1\tUnit2\tUnit3\tUnit4\tUnit5\tTotal\tAverage\tGrade");
            for (Student student : students) {
                System.out.println(student);
            }
        }

        System.out.print("Do you want to add a student marks?: ");
        if (scanner.nextLine().equalsIgnoreCase("Y")) {
            menu();
        }
    }

    // Confirm exit
    public static void confirmExit() {
        System.out.print("Are you sure you want to quit? (Y/N): ");
        if (!scanner.nextLine().equalsIgnoreCase("Y")) {
            menu();
        } else {
            System.out.println("Program exited.");
        }
    }
}
