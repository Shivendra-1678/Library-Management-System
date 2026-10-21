
public class Book {

    private int id;
    private String title;
    private String author;
    private boolean issued;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.issued = false;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return issued;
    }

    public void issueBook() {
        issued = true;
    }

    public void returnBook() {
        issued = false;
    }

    public void displayBook() {
        System.out.println(
            "ID: " + id +
            " | Title: " + title +
            " | Author: " + author +
            " | Status: " + (issued ? "Issued" : "Available")
        );
    }
}