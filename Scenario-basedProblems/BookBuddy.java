import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

// Custom exception jab book ka format galat ho
class InvalidBookFormatException extends Exception {
    public InvalidBookFormatException(String message) {
        super(message);
    }
}

public class BookBuddy {

    private List<String> bookshelf;

    public BookBuddy() {
        this.bookshelf = new ArrayList<>();
    }

    // Nayi book add karne ke liye method
    public void addBook(String title, String author) {
        String bookString = title.trim() + " - " + author.trim();
        bookshelf.add(bookString);
        System.out.println("Book added: " + bookString);
    }

    // Books ko alphabetically sort karne ke liye method
    public void sortBooksAlphabetically() {
        if (bookshelf.isEmpty()) {
            System.out.println("Bookshelf khali hai, sorting nahi ho sakti.");
            return;
        }
        Collections.sort(bookshelf);
        System.out.println("\nBooks sorted alphabetically.");
    }

    // Author ke naam se books search karne ke liye method
    public List<String> searchByAuthor(String author) throws InvalidBookFormatException {
        if (bookshelf.isEmpty()) {
            System.out.println("\nBookshelf khali hai, search nahi ho sakta.");
            return new ArrayList<>();
        }

        System.out.println("\n'" + author + "' dwara likhi gayi books search kar rahe hain...");
        List<String> results = new ArrayList<>();
        String lowerCaseAuthor = author.toLowerCase();

        for (String book : bookshelf) {
            String[] parts = book.split(" - ");
            if (parts.length != 2) {
                throw new InvalidBookFormatException("Galat format: '" + book + "'. Iska format 'Title - Author' hona chahiye.");
            }
            if (parts[1].trim().toLowerCase().equals(lowerCaseAuthor)) {
                results.add(book);
            }
        }
        return results;
    }

    // List ko array mein convert karne ke liye method
    public String[] toArray() {
        return bookshelf.toArray(new String[0]);
    }

    // Bookshelf ko print karne ke liye method
    public void displayBookshelf() {
        System.out.println("\n--- Current Bookshelf ---");
        if (bookshelf.isEmpty()) {
            System.out.println("Koi books nahi hain.");
            return;
        }
        for (String book : bookshelf) {
            System.out.println(book);
        }
    }

    public static void main(String[] args) {
        BookBuddy myBookshelf = new BookBuddy();

        // Books add kar rahe hain
        myBookshelf.addBook("The Alchemist", "Paulo Coelho");
        myBookshelf.addBook("The Little Prince", "Antoine de Saint-Exupéry");
        myBookshelf.addBook("The Lord of the Rings", "J.R.R. Tolkien");
        myBookshelf.addBook("The Catcher in the Rye", "J.D. Salinger");

        myBookshelf.displayBookshelf();

        // Books ko sort kar rahe hain
        myBookshelf.sortBooksAlphabetically();
        myBookshelf.displayBookshelf();

        // Author ke naam se search kar rahe hain
        try {
            List<String> coelhoBooks = myBookshelf.searchByAuthor("Paulo Coelho");
            if (coelhoBooks.isEmpty()) {
                System.out.println("Koi books nahi mili.");
            } else {
                System.out.println("Books by Paulo Coelho:");
                coelhoBooks.forEach(System.out::println);
            }
        } catch (InvalidBookFormatException e) {
            System.err.println("Search failed: " + e.getMessage());
        }

        // Empty list ko handle karne ka example
        BookBuddy emptyBookshelf = new BookBuddy();
        emptyBookshelf.sortBooksAlphabetically();
        try {
            emptyBookshelf.searchByAuthor("Dummy Author");
        } catch (InvalidBookFormatException e) {
            // This won't be triggered, as the list is empty and method returns early
        }

        // List ko array mein convert kar rahe hain
        String[] exportedBooks = myBookshelf.toArray();
        System.out.println("\n--- Exported to Array ---");
        for (String book : exportedBooks) {
            System.out.println(book);
        }

        // Invalid format ko handle karne ka example
        System.out.println("\n--- Invalid format example ---");
        try {
            List<String> invalidSearch = new ArrayList<>();
            invalidSearch.add("Invalid Book Format");
            BookBuddy invalidBookshelf = new BookBuddy();
            invalidBookshelf.bookshelf = invalidSearch;
            invalidBookshelf.searchByAuthor("Test");
        } catch (InvalidBookFormatException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
