import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Book class
class Book {
    private String title;
    private String author;
    private String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    // Display book info
    public void displayInfo() {
        System.out.println("Title : " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN  : " + isbn);
        System.out.println("---------------------------");
    }
}

// Library Catalog System
public class LibraryCatalog {
    private static List<Book> catalog = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n📚 Library Catalog System");
            System.out.println("1. Add a new Book");
            System.out.println("2. Search Book by Title");
            System.out.println("3. Search Book by Author");
            System.out.println("4. List all Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1: addBook(); break;
                case 2: searchByTitle(); break;
                case 3: searchByAuthor(); break;
                case 4: listBooks(); break;
                case 5: System.out.println("Exiting... Goodbye!"); break;
                default: System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);
    }

    // Add new book
    private static void addBook() {
        System.out.print("Enter Book Title : ");
        String title = scanner.nextLine();
        System.out.print("Enter Author Name: ");
        String author = scanner.nextLine();
        System.out.print("Enter ISBN        : ");
        String isbn = scanner.nextLine();

        Book newBook = new Book(title, author, isbn);
        catalog.add(newBook);
        System.out.println("Book added successfully!");
    }

    // Search book by title
    private static void searchByTitle() {
        System.out.print("Enter book title to search: ");
        String title = scanner.nextLine().toLowerCase();
        boolean found = false;

        for (Book book : catalog) {
            if (book.getTitle().toLowerCase().contains(title)) {
                book.displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books found with that title.");
        }
    }

    // Search book by author
    private static void searchByAuthor() {
        System.out.print("Enter author name to search: ");
        String author = scanner.nextLine().toLowerCase();
        boolean found = false;

        for (Book book : catalog) {
            if (book.getAuthor().toLowerCase().contains(author)) {
                book.displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books found by that author.");
        }
    }

    // List all books
    private static void listBooks() {
        if (catalog.isEmpty()) {
            System.out.println("No books available in the catalog.");
        } else {
            System.out.println("\nAll Available Books:");
            for (Book book : catalog) {
                book.displayInfo();
            }
        }
    }
}
