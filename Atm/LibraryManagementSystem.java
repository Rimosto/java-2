import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String studentNumber;
    String isbn;
    String title;

    Book(String studentNumber, String isbn, String title) {
        this.studentNumber = studentNumber;
        this.isbn = isbn;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Registration Number: " + studentNumber + ", ISBN: " + isbn + ", Title: " + title;
    }
}

public class LibraryManagementSystem {

    static final String DEFAULT_PASSWORD = "Admin123";
    static ArrayList<Book> borrowedBooks = new ArrayList<>();
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
        return false; //0791494683
    }

    // Main menu
    public static void menu() {
        int choice;
        do {
            System.out.println("\nSYSTECH Library Management System:");
            System.out.println("1. Borrow a book");
            System.out.println("2. View borrowed books");
            System.out.println("3. Return a book");
            System.out.println("4. Quit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    borrowBook();
                    break;
                case 2:
                    viewBorrowedBooks();
                    break;
                case 3:
                    returnBook();
                    break;
                case 4:
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Invalid option, try again.");
            }
        } while (choice != 4);
    }

    // Borrowing a book
    public static void borrowBook() {
        do {
            System.out.print("Enter student number: ");
            String studentNumber = scanner.nextLine();

            System.out.print("Enter ISBN number: ");
            String isbn = scanner.nextLine();

            System.out.print("Enter book title: ");
            String title = scanner.nextLine();

            borrowedBooks.add(new Book(studentNumber, isbn, title));

            System.out.print("Do you want to issue another book? (Y/N): ");
        } while (scanner.nextLine().equalsIgnoreCase("Y"));

        System.out.println("Book(s) issued successfully.");
    }

    // Viewing borrowed books
    public static void viewBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println("No borrowed books.");
        } else {
            System.out.println("Borrowed Books:");
            for (Book book : borrowedBooks) {
                System.out.println(book);
            }
        }
    }

    // Returning a book
    public static void returnBook() {
        System.out.print("Enter ISBN number of the book to return: ");
        String isbn = scanner.nextLine();

        Book toReturn = null;
        for (Book book : borrowedBooks) {
            if (book.isbn.equals(isbn)) {
                toReturn = book;
                break;
            }
        }

        if (toReturn != null) {
            borrowedBooks.remove(toReturn);
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("No matching book found for the given ISBN.");
        }
    }
}
