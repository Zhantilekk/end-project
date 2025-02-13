import java.util.Scanner;

/**
 * Main class for the Library Management System terminal application.
 */
public class Main {
    public static void main(String[] args) {
        // Create repository instance (concrete implementation of IBookRepository)
        BookRepository bookRepository = new BookRepository();

        LibraryService libraryService = new LibraryService(bookRepository);

        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 4) {
            System.out.println("==== Library Management System ====");
            System.out.println("1. Add a new book");
            System.out.println("2. Display all books");
            System.out.println("3. Delete a book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter book ID: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    // Using Factory Pattern to create a new Book object
                    Book newBook = BookFactory.createBook(id, title, author);
                    libraryService.addBook(newBook);
                    break;
                case 2:
                    libraryService.listBooks();
                    break;
                case 3:
                    System.out.print("Enter book ID to delete: ");
                    int deleteId = Integer.parseInt(scanner.nextLine());
                    libraryService.deleteBook(deleteId);
                    break;
                case 4:
                    System.out.println("Exiting the application.");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
        scanner.close();
    }
}