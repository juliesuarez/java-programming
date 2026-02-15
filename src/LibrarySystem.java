import java.util.HashMap;
import java.util.Scanner;

/**
 * Basic Library System
 * allows users to add, borrow, and return books.
 */
public class LibrarySystem {

    // Inner class to represent a Book object
    static class Book {
        String title;
        String author;
        int quantity;

        public Book(String title, String author, int quantity) {
            this.title = title;
            this.author = author;
            this.quantity = quantity;
        }
    }

    // Storage for the library: Key = Title (lowercase), Value = Book object
    private static HashMap<String, Book> libraryInventory = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;

        System.out.println("Welcome to the Library Management System");

        while (!exit) {
            printMenu();
            int choice = -1;

            // Handle invalid menu inputs (non-integers)
            try {
                System.out.print("Enter your choice: ");
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number between 1 and 4.");
                continue;
            }

            switch (choice) {
                case 1:
                    addBooks();
                    break;
                case 2:
                    borrowBooks();
                    break;
                case 3:
                    returnBooks();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select an option from 1 to 4.");
            }
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n--------------------------------");
        System.out.println("1. Add Books");
        System.out.println("2. Borrow Books");
        System.out.println("3. Return Books");
        System.out.println("4. Exit");
        System.out.println("--------------------------------");
    }

    private static void addBooks() {
        System.out.println("\n--- Add Books ---");
        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine().trim();

        if (title.isEmpty()) {
            System.out.println("Error: Title cannot be empty.");
            return;
        }

        // Check if book exists (case-insensitive key)
        String key = title.toLowerCase();

        if (libraryInventory.containsKey(key)) {
            // Book exists, just update quantity
            Book existingBook = libraryInventory.get(key);
            System.out.println("Book found! Current quantity: " + existingBook.quantity);

            int quantityToAdd = getValidPositiveInteger("Enter quantity to add: ");
            existingBook.quantity += quantityToAdd;
            System.out.println("Quantity updated. Total '" + existingBook.title + "' in stock: " + existingBook.quantity);
        } else {
            // New book
            System.out.print("Enter Author Name: ");
            String author = scanner.nextLine().trim();
            int quantity = getValidPositiveInteger("Enter initial quantity: ");

            Book newBook = new Book(title, author, quantity);
            libraryInventory.put(key, newBook);
            System.out.println("Book added successfully!");
        }
    }

    private static void borrowBooks() {
        System.out.println("\n--- Borrow Books ---");
        System.out.print("Enter Book Title to borrow: ");
        String title = scanner.nextLine().trim();
        String key = title.toLowerCase();

        if (libraryInventory.containsKey(key)) {
            Book book = libraryInventory.get(key);
            System.out.println("Available copies: " + book.quantity);

            if (book.quantity == 0) {
                System.out.println("Sorry, this book is currently out of stock.");
                return;
            }

            int borrowQty = getValidPositiveInteger("Enter number of books to borrow: ");

            if (borrowQty <= book.quantity) {
                book.quantity -= borrowQty;
                System.out.println("Success! You have borrowed " + borrowQty + " cop(ies) of '" + book.title + "'.");
            } else {
                System.out.println("Error: Not enough copies available. You requested " + borrowQty + ", but only " + book.quantity + " are left.");
            }
        } else {
            System.out.println("Error: Book not found in the library system.");
        }
    }

    private static void returnBooks() {
        System.out.println("\n--- Return Books ---");
        System.out.print("Enter Book Title to return: ");
        String title = scanner.nextLine().trim();
        String key = title.toLowerCase();

        // The requirement: "Check if the books being returned belong to the library system."
        if (libraryInventory.containsKey(key)) {
            Book book = libraryInventory.get(key);
            int returnQty = getValidPositiveInteger("Enter number of books to return: ");

            book.quantity += returnQty;
            System.out.println("Success! You returned " + returnQty + " cop(ies) of '" + book.title + "'.");
            System.out.println("Total now in stock: " + book.quantity);
        } else {
            System.out.println("Error: This book does not belong to our library system (Title not found).");
        }
    }

    // Helper method to ensure user enters a valid positive integer
    private static int getValidPositiveInteger(String prompt) {
        int value = -1;
        while (value < 0) {
            System.out.print(prompt);
            try {
                value = Integer.parseInt(scanner.nextLine());
                if (value < 0) {
                    System.out.println("Please enter a positive number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            }
        }
        return value;
    }
}