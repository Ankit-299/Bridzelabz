// Superclass
class BaseVehicle {
    private int maxSpeed;
    private String model;

    public BaseVehicle(int maxSpeed, String model) {
        this.maxSpeed = maxSpeed;
        this.model = model;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public String getModel() {
        return model;
    }

    public void displayInfo() {
        System.out.println("Model: " + model + ", Max Speed: " + maxSpeed + " km/h");
    }
}

// Interface for additional behavior
interface Refuelable {
    void refuel();
}

// Subclass: Electric Car
class ElectricCar extends BaseVehicle {
    private int batteryCapacity;

    public ElectricCar(int maxSpeed, String model, int batteryCapacity) {
        super(maxSpeed, model);
        this.batteryCapacity = batteryCapacity;
    }

    public void charge() {
        System.out.println(getModel() + " is charging. Battery capacity: " + batteryCapacity + " kWh");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
    }
}

// Subclass: Petrol Car (inherits BaseVehicle + implements Refuelable)
class PetrolCar extends BaseVehicle implements Refuelable {
    private int fuelTankCapacity;

    public PetrolCar(int maxSpeed, String model, int fuelTankCapacity) {
        super(maxSpeed, model);
        this.fuelTankCapacity = fuelTankCapacity;
    }

    @Override
    public void refuel() {
        System.out.println(getModel() + " is refueling. Tank capacity: " + fuelTankCapacity + " liters");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Fuel Tank Capacity: " + fuelTankCapacity + " liters");
    }
}

// Test Main Class
public class VehicleSystemDemo {
    public static void main(String[] args) {
        BaseVehicle tesla = new ElectricCar(250, "Tesla Model S", 100);
        BaseVehicle honda = new PetrolCar(180, "Honda City", 40);

        tesla.displayInfo();
        ((ElectricCar) tesla).charge();

        System.out.println();

        honda.displayInfo();
        ((PetrolCar) honda).refuel();
    }
}
