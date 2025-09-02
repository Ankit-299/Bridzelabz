class MobilePhone {
    String brand;
    String model;
    double price;

    MobilePhone(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("----- Mobile Phone Details -----");
        System.out.println("Brand : " + brand);
        System.out.println("Model : " + model);
        System.out.println("Price : " + price);
    }
}

public class MobilePhoneDemo {
    public static void main(String[] args) {
        MobilePhone m1 = new MobilePhone("Apple", "iPhone 15", 129000);
        MobilePhone m2 = new MobilePhone("Samsung", "Galaxy S24", 115000);

        m1.displayDetails();
        System.out.println();
        m2.displayDetails();
    }
}
