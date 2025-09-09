class LibraryBook {
    String title;
    String author;
    double price;
    boolean available;

    LibraryBook(String t, String a, double p, boolean av) {
        title = t;
        author = a;
        price = p;
        available = av;
    }

    void borrowBook() {
        if (available) {
            available = false;
            System.out.println(title + " has been borrowed.");
        } else {
            System.out.println(title + " is not available.");
        }
    }

    void display() {
        System.out.println("Title: " + title + ", Author: " + author + ", Price: " + price + ", Available: " + available);
    }
}

public class Main {
    public static void main(String[] args) {
        LibraryBook b1 = new LibraryBook("Java Programming", "James Gosling", 499.99, true);
        b1.display();

        b1.borrowBook();
        b1.display();

        b1.borrowBook();
    }
}
