class Item {
    int itemCode;
    String itemName;
    double price;

    Item(int itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

    public double calculateTotalCost(int quantity) {
        return price * quantity;
    }

    public void displayDetails(int quantity) {
        System.out.println("----- Item Details -----");
        System.out.println("Item Code : " + itemCode);
        System.out.println("Item Name : " + itemName);
        System.out.println("Price     : " + price);
        System.out.println("Quantity  : " + quantity);
        System.out.println("Total Cost: " + calculateTotalCost(quantity));
    }
}

public class InventoryDemo {
    public static void main(String[] args) {
        Item i1 = new Item(101, "Laptop", 55000);
        Item i2 = new Item(102, "Mouse", 700);

        i1.displayDetails(2);
        System.out.println();
        i2.displayDetails(5);
    }
}
