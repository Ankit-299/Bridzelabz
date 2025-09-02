import java.util.ArrayList;

class CartItem {
    String itemName;
    double price;
    int quantity;

    CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return price * quantity;
    }
}

class ShoppingCart {
    ArrayList<CartItem> items = new ArrayList<>();

    public void addItem(String name, double price, int quantity) {
        CartItem item = new CartItem(name, price, quantity);
        items.add(item);
        System.out.println(quantity + " x " + name + " added to cart.");
    }

    public void removeItem(String name) {
        boolean removed = false;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).itemName.equalsIgnoreCase(name)) {
                items.remove(i);
                removed = true;
                System.out.println(name + " removed from cart.");
                break;
            }
        }
        if (!removed) {
            System.out.println(name + " not found in cart.");
        }
    }

    public void displayTotalCost() {
        double total = 0;
        System.out.println("----- Cart Summary -----");
        for (CartItem item : items) {
            System.out.println(item.itemName + " (" + item.quantity + " x " + item.price + ") = " + item.getTotalPrice());
            total += item.getTotalPrice();
        }
        System.out.println("Total Cost: " + total);
    }
}

public class ShoppingCartDemo {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addItem("Apple", 50, 3);
        cart.addItem("Milk", 40, 2);
        cart.addItem("Bread", 30, 1);

        cart.displayTotalCost();
        System.out.println();

        cart.removeItem("Milk");
        cart.displayTotalCost();
    }
}
