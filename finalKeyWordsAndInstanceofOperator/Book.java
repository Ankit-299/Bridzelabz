private final String isbn;
private String title;
private String author;
private boolean checkedOut;

public Book(String title, String author, String isbn) {
    this.title = title;
    this.author = author;
    this.isbn = isbn;
    this.checkedOut = false;
}

public static void displayLibraryName() {
    System.out.println("Library: " + libraryName);
}

public static String getLibraryName() {
    return libraryName;
}

public static void setLibraryName(String newName) {
    libraryName = newName;
}

public String getTitle() {
    return title;
}

public String getAuthor() {
    return author;
}

public String getIsbn() {
    return isbn;
}

public boolean isCheckedOut() {
    return checkedOut;
}

public void checkOut() {
    if (!checkedOut) checkedOut = true;
}

public void returnBook() {
    if (checkedOut) checkedOut = false;
}

@Override
public String toString() {
    return "Book {" +
           "libraryName='" + libraryName + '\'' +
           ", title='" + title + '\'' +
           ", author='" + author + '\'' +
           ", isbn='" + isbn + '\'' +
           ", checkedOut=" + checkedOut +
           '}';
}

public static void main(String[] args) {
    Book b1 = new Book("1984", "George Orwell", "ISBN-001");
    Book b2 = new Book("To Kill a Mockingbird", "Harper Lee", "ISBN-002");

    Book.displayLibraryName();

    System.out.println(b1);
    System.out.println(b2);

    b1.checkOut();
    System.out.println("After checking out b1:");
    System.out.println(b1);

    Book.setLibraryName("Downtown Public Library");
    System.out.println("After renaming library:");
    Book.displayLibraryName();
    System.out.println(b2);
}
}
