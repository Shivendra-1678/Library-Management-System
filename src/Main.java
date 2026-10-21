
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        int choice = 0;

        do {

            System.out.println("\n================================");
            System.out.println("   LIBRARY MANAGEMENT SYSTEM");
            System.out.println("================================");
            System.out.println("1. Add Book");
            System.out.println("2. Display All Books");
            System.out.println("3. Search Book by ID");
            System.out.println("4. Search Book by Title");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("7. Display Available Books");
            System.out.println("8. Display Issued Books");
            System.out.println("9. Sort Books by Title");
            System.out.println("10. Delete Book");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");

            try {

                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1:
                        System.out.print("Enter Book ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Book Title: ");
                        String title = sc.nextLine();

                        System.out.print("Enter Author Name: ");
                        String author = sc.nextLine();

                        if (title.isBlank() || author.isBlank()) {
                            System.out.println(
                                "Title and author cannot be empty."
                            );
                            break;
                        }

                        if (id <= 0) {
                            System.out.println(
                                "Book ID must be positive."
                            );
                            break;
                        }

                        library.addBook(
                            new Book(id, title, author)
                        );
                        break;

                    case 2:
                        library.displayBooks();
                        break;

                    case 3:
                        System.out.print("Enter Book ID: ");
                        id = sc.nextInt();
                        sc.nextLine();

                        library.searchBookById(id).displayBook();
                        break;

                    case 4:
                        System.out.print("Enter Book Title: ");
                        title = sc.nextLine();

                        library.searchBookByTitle(title);
                        break;

                    case 5:
                        System.out.print("Enter Book ID: ");
                        id = sc.nextInt();
                        sc.nextLine();

                        library.issueBook(id);
                        break;

                    case 6:
                        System.out.print("Enter Book ID: ");
                        id = sc.nextInt();
                        sc.nextLine();

                        library.returnBook(id);
                        break;

                    case 7:
                        library.displayAvailableBooks();
                        break;

                    case 8:
                        library.displayIssuedBooks();
                        break;

                    case 9:
                        library.sortBooksByTitle();
                        break;

                    case 10:
                        System.out.print("Enter Book ID: ");
                        id = sc.nextInt();
                        sc.nextLine();

                        library.deleteBook(id);
                        break;

                    case 11:
                        System.out.println(
                            "Thank you for using the Library Management System!"
                        );
                        break;

                    default:
                        System.out.println(
                            "Invalid choice! Enter a number from 1 to 11."
                        );
                }

            } catch (InputMismatchException e) {

                System.out.println(
                    "Invalid input! Please enter the correct data type."
                );

                sc.nextLine();

            } catch (BookNotFoundException e) {

                System.out.println(e.getMessage());

            } finally {
                System.out.println("Operation completed.");
            }

        } while (choice != 11);

        sc.close();
    }
}