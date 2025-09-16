abstract class Vehicle {
    private int maxSpeed;
    private String fuelType;

    public Vehicle(int maxSpeed, String fuelType) {
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public String getFuelType() {
        return fuelType;
    }

    public abstract void displayInfo();
}

class Car extends Vehicle {
    private int seatCapacity;

    public Car(int maxSpeed, String fuelType, int seatCapacity) {
        super(maxSpeed, fuelType);
        this.seatCapacity = seatCapacity;
    }

    @Override
    public void displayInfo() {
        System.out.println("Car -> Max Speed: " + getMaxSpeed() +
                " km/h, Fuel: " + getFuelType() +
                ", Seats: " + seatCapacity);
    }
}

class Truck extends Vehicle {
    private double loadCapacity;

    public Truck(int maxSpeed, String fuelType, double loadCapacity) {
        super(maxSpeed, fuelType);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public void displayInfo() {
        System.out.println("Truck -> Max Speed: " + getMaxSpeed() +
                " km/h, Fuel: " + getFuelType() +
                ", Load Capacity: " + loadCapacity + " tons");
    }
}

class Motorcycle extends Vehicle {
    private boolean hasSidecar;

    public Motorcycle(int maxSpeed, String fuelType, boolean hasSidecar) {
        super(maxSpeed, fuelType);
        this.hasSidecar = hasSidecar;
    }

    @Override
    public void displayInfo() {
        System.out.println("Motorcycle -> Max Speed: " + getMaxSpeed() +
                " km/h, Fuel: " + getFuelType() +
                ", Sidecar: " + (hasSidecar ? "Yes" : "No"));
    }
}

public class TransportSystem {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
                new Car(180, "Petrol", 5),
                new Truck(120, "Diesel", 15),
                new Motorcycle(150, "Petrol", false)
        };

        for (Vehicle v : vehicles) {
            v.displayInfo();
        }
    }
}
