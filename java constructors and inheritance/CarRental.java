class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
    double dailyRate;

    CarRental() {
        customerName = "Unknown";
        carModel = "Standard";
        rentalDays = 1;
        dailyRate = 1000.0;
    }

    CarRental(String c, String m, int d, double rate) {
        customerName = c;
        carModel = m;
        rentalDays = d;
        dailyRate = rate;
    }

    double calculateTotalCost() {
        return rentalDays * dailyRate;
    }

    void display() {
        System.out.println("Customer: " + customerName + ", Car: " + carModel + 
                           ", Days: " + rentalDays + ", Total Cost: " + calculateTotalCost());
    }
}

public class Main {
    public static void main(String[] args) {
        CarRental r1 = new CarRental();
        r1.display();

        CarRental r2 = new CarRental("Ankit", "Honda City", 5, 1500.0);
        r2.display();
    }
}
