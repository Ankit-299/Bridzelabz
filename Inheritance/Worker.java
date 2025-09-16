// Interface - Worker
interface Worker {
    void performDuties();  // Must be implemented by Chef and Waiter
}

// Superclass - Person
abstract class Person {
    private String name;
    private int id;

    // Constructor
    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Getters (encapsulation - no public fields)
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    // Common method
    public void displayInfo() {
        System.out.println("ID: " + id + ", Name: " + name);
    }
}

// Subclass - Chef (inherits Person + implements Worker)
class Chef extends Person implements Worker {
    private String specialty;

    public Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }

    @Override
    public void performDuties() {
        System.out.println(getName() + " (Chef) is cooking " + specialty + " dishes.");
    }
}

// Subclass - Waiter (inherits Person + implements Worker)
class Waiter extends Person implements Worker {
    private int tableAssigned;

    public Waiter(String name, int id, int tableAssigned) {
        super(name, id);
        this.tableAssigned = tableAssigned;
    }

    @Override
    public void performDuties() {
        System.out.println(getName() + " (Waiter) is serving table " + tableAssigned + ".");
    }
}

// Demo class
public class RestaurantManagement {
    public static void main(String[] args) {
        Worker chef = new Chef("Rajesh", 101, "Italian");
        Worker waiter = new Waiter("Aman", 201, 5);

        // Polymorphism - both are Worker
        chef.performDuties();
        waiter.performDuties();

        // Also access Person info via casting
        ((Person
