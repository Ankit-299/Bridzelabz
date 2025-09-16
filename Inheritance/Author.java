class Author {
    private String name;
    private String bio;

    public Author(String name, String bio) {
        this.name = name;
        this.bio = bio;
    }

    public String getName() { return name; }
    public String getBio() { return bio; }
}

class Book {
    private String title;
    private int publicationYear;
    private Author author; // Composition: Book has an Author

    public Book(String title, int publicationYear, Author author) {
        this.title = title;
        this.publicationYear = publicationYear;
        this.author = author;
    }

    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Year: " + publicationYear);
        System.out.println("Author: " + author.getName());
        System.out.println("Bio: " + author.getBio());
    }
}

public class Main {
    public static void main(String[] args) {
        Author a1 = new Author("George Orwell", "English novelist and critic");
        Book b1 = new Book("1984", 1949, a1);

        b1.displayInfo();
    }
}
