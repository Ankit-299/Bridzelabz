class Vehicle {
    static double registrationFee = 5000;
    private static int totalVehicles = 0;

    private final String registrationNumber;
    private String ownerName;
    private String vehicleType;

    public Vehicle(String registrationNumber, String ownerName, String vehicleType) {
        this.registrationNumber = registrationNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        totalVehicles++;
    }

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    public void displayDetails(Object obj) {
        if (obj instanceof Vehicle) {
            Vehicle v = (Vehicle) obj;
            System.out.println("Registration Number: " + v.registrationNumber);
            System.out.println("Owner Name: " + v.ownerName);
            System.out.println("Vehicle Type: " + v.vehicleType);
            System.out.println("Registration Fee: " + registrationFee);
            System.out.println("----------------------");
        } else {
            System.out.println("Invalid Vehicle object!");
        }
    }

    public static void displayTotalVehicles() {
        System.out.println("Total Vehicles Registered: " + totalVehicles);
    }
}

public class VehicleRegistrationSystem {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("DL10AB1234", "Amit", "Car");
        Vehicle v2 = new Vehicle("DL05XY9876", "Riya", "Bike");

        v1.displayDetails(v1);
        v2.displayDetails(v2);

        Vehicle.updateRegistrationFee(6000);
        v1.displayDetails(v1);

        String dummy = "Hello";
        v1.displayDetails(dummy);

        Vehicle.displayTotalVehicles();
    }
}
