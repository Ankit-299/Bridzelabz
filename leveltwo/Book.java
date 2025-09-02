class Book {
    String title;
    String author;
    double price;

    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("----- Book Details -----");
        System.out.println("Title  : " + title);
        System.out.println("Author : " + author);
        System.out.println("Price  : " + price);
    }
}

public class BookDemo {
    public static void main(String[] args) {
        Book b1 = new Book("The Alchemist", "Paulo Coelho", 399.0);
        Book b2 = new Book("Wings of Fire", "A.P.J. Abdul Kalam", 299.0);

        b1.displayDetails();
        System.out.println();
        b2.displayDetails();
    }
}
