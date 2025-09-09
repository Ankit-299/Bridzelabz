class Circle {
    double radius;

    Circle() {
        this(1.0);
    }

    Circle(double r) {
        this.radius = r;
    }

    void display() {
        System.out.println("Radius: " + radius);
    }
}

public class Main {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        c1.display();

        Circle c2 = new Circle(5.5);
        c2.display();
    }
}
