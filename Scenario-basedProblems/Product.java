import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Comparator;

// Custom exception for invalid stock updates
class InvalidStockException extends Exception {
    public InvalidStockException(String message) {
        super(message);
    }
}

// Product ki details store karne ke liye class
class Product {
    private String name;
    private String category;
    private double price;
    private int stock;

    public Product(String name, String category, double price, int stock) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    // Stock update karne ke liye method
    public void setStock(int newStock) throws InvalidStockException {
        // Stock negative ya max limit se zyada nahi ho sakta
        if (newStock < 0 || newStock > 1000) {
            throw new InvalidStockException("Stock 0 aur 1000 ke beech mein hona chahiye.");
        }
        this.stock = newStock;
    }

    @Override
    public String toString() {
        return String.format("Product: %-20s | Category: %-15s | Price: Rs %-10.2f | Stock: %d",
                name, category, price, stock);
    }
}

// E-commerce catalog ko manage karne ke liye main class
public class ECommerceCatalog {

    private List<Product> products;

    public ECommerceCatalog() {
        this.products = new ArrayList<>();
    }

    // Naya product add karne ke liye method
    public void addProduct(String name, String category, double price, int stock) {
        try {
            Product newProduct = new Product(name, category, price, stock);
            products.add(newProduct);
            System.out.println("Product added successfully: " + newProduct.getName());
        } catch (InvalidStockException e) {
            System.err.println("Error adding product: " + e.getMessage());
        }
    }

    // Product ko name ya category se search karne ke liye method
    public List<Product> searchProducts(String query) {
        List<Product> results = new ArrayList<>();
        String lowerCaseQuery = query.toLowerCase();
        
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(lowerCaseQuery) ||
                product.getCategory().toLowerCase().contains(lowerCaseQuery)) {
                results.add(product);
            }
        }
        return results;
    }

    // Kisi product ka stock update karne ke liye method
    public void updateStock(String productName, int newStock) {
        Optional<Product> productToUpdate = products.stream()
            .filter(p -> Objects.equals(p.getName(), productName))
            .findFirst();

        if (productToUpdate.isPresent()) {
            try {
                productToUpdate.get().setStock(newStock);
                System.out.println("Stock updated successfully for: " + productName);
            } catch (InvalidStockException e) {
                System.err.println("Stock update failed for " + productName + ": " + e.getMessage());
            }
        } else {
            System.err.println("Error: Product '" + productName + "' nahi mila.");
        }
    }

    // Saare products ko price ke hisaab se sort karke report generate karne ke liye method
    public void generatePriceReport(boolean ascending) {
        List<Product> sortedProducts = new ArrayList<>(products);
        if (ascending) {
            Collections.sort(sortedProducts, Comparator.comparingDouble(Product::getPrice));
        } else {
            Collections.sort(sortedProducts, Comparator.comparingDouble(Product::getPrice).reversed());
        }
        
        System.out.println("\n--- Product Price Report (Sorted by Price) ---");
        for (Product product : sortedProducts) {
            System.out.println(product);
        }
        System.out.println("----------------------------------------------");
    }

    public static void main(String[] args) {
        ECommerceCatalog catalog = new ECommerceCatalog();

        // Products add kar rahe hain
        System.out.println("--- Products add kar rahe hain ---");
        catalog.addProduct("Laptop", "Electronics", 75000.00, 50);
        catalog.addProduct("T-Shirt", "Apparel", 800.00, 200);
        catalog.addProduct("Mobile Phone", "Electronics", 35000.00, 120);
        catalog.addProduct("Coffee Mug", "Home Goods", 250.00, 500);
        catalog.addProduct("Running Shoes", "Apparel", 3000.00, 80);

        // Products search kar rahe hain
        System.out.println("\n--- 'electronics' ke liye search results ---");
        List<Product> electronics = catalog.searchProducts("electronics");
        electronics.forEach(System.out::println);

        System.out.println("\n--- 'Shoes' ke liye search results ---");
        List<Product> shoes = catalog.searchProducts("Shoes");
        shoes.forEach(System.out::println);
        
        // Stock update kar rahe hain
        System.out.println("\n--- Stock update kar rahe hain ---");
        catalog.updateStock("Laptop", 45); // Valid update
        catalog.updateStock("T-Shirt", 1500); // Invalid stock (max limit)
        catalog.updateStock("Jacket", 50); // Non-existent product
        catalog.updateStock("Mobile Phone", -10); // Invalid stock (negative)

        // Price report generate kar rahe hain
        catalog.generatePriceReport(true); // Ascending order
        catalog.generatePriceReport(false); // Descending order
    }
}
