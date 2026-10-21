
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Comparator;
import java.util.Map;

public class Library {

    private ArrayList<Book> books = new ArrayList<>();
    private HashMap<Integer, Book> bookMap = new HashMap<>();

    // Add a new book
    public void addBook(Book book) {

        if (bookMap.containsKey(book.getId())) {
            System.out.println("Error: Book ID already exists!");
            return;
        }

        books.add(book);
        bookMap.put(book.getId(), book);

        System.out.println("Book added successfully!");
    }

    // Display all books
    public void displayBooks() {

        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        for (Book book : books) {
            book.displayBook();
        }
    }

    // Search book by ID
    public Book searchBookById(int id)
            throws BookNotFoundException {

        Book book = bookMap.get(id);

        if (book == null) {
            throw new BookNotFoundException(
                "Book with ID " + id + " not found!"
            );
        }

        return book;
    }

    // Search book by title
    public void searchBookByTitle(String title) {

        boolean found = false;

        for (Book book : books) {

            if (book.getTitle().equalsIgnoreCase(title)) {
                book.displayBook();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Book not found!");
        }
    }

    // Issue a book
    public void issueBook(int id)
            throws BookNotFoundException {

        Book book = searchBookById(id);

        if (book.isIssued()) {
            System.out.println("Book is already issued!");
            return;
        }

        book.issueBook();

        System.out.println("Book issued successfully!");
    }

    // Return a book
    public void returnBook(int id)
            throws BookNotFoundException {

        Book book = searchBookById(id);

        if (!book.isIssued()) {
            System.out.println("Book is already available!");
            return;
        }

        book.returnBook();

        System.out.println("Book returned successfully!");
    }

    // Display available books
    public void displayAvailableBooks() {

        boolean found = false;

        for (Book book : books) {

            if (!book.isIssued()) {
                book.displayBook();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No available books.");
        }
    }

    // Display issued books
    public void displayIssuedBooks() {

        boolean found = false;

        for (Book book : books) {

            if (book.isIssued()) {
                book.displayBook();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No issued books.");
        }
    }

    // Sort books alphabetically
    public void sortBooksByTitle() {

        books.sort(
            Comparator.comparing(
                Book::getTitle,
                String.CASE_INSENSITIVE_ORDER
            )
        );

        System.out.println("Books sorted by title.");
    }

    // Delete a book
    public void deleteBook(int id)
            throws BookNotFoundException {

        Book book = searchBookById(id);

        if (book.isIssued()) {
            System.out.println(
                "Cannot delete an issued book. Return it first."
            );
            return;
        }

        books.remove(book);
        bookMap.remove(id);

        System.out.println("Book deleted successfully!");
    }
}