class Product {
    static double discount = 10.0;
    private static int totalProducts = 0;

    private final int productID;
    private String productName;
    private double price;
    private int quantity;

    public Product(int productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        totalProducts++;
    }

    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    public void displayDetails(Object obj) {
        if (obj instanceof Product) {
            Product p = (Product) obj;
            double totalPrice = p.price * p.quantity;
            double discountedPrice = totalPrice - (totalPrice * discount / 100);
            System.out.println("Product ID: " + p.productID);
            System.out.println("Name: " + p.productName);
            System.out.println("Price: " + p.price);
            System.out.println("Quantity: " + p.quantity);
            System.out.println("Total Price: " + totalPrice);
            System.out.println("After Discount: " + discountedPrice);
            System.out.println("----------------------");
        } else {
            System.out.println("Invalid Product object!");
        }
    }
}

public class ShoppingCart {
    public static void main(String[] args) {
        Product p1 = new Product(1, "Laptop", 50000, 1);
        Product p2 = new Product(2, "Headphones", 2000, 2);

        p1.displayDetails(p1);
        p2.displayDetails(p2);

        Product.updateDiscount(20);
        p1.displayDetails(p1);
    }
}
