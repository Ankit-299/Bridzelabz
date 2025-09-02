class Circle {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }

    public void displayDetails() {
        System.out.println("----- Circle Details -----");
        System.out.println("Radius        : " + radius);
        System.out.println("Area          : " + calculateArea());
        System.out.println("Circumference : " + calculateCircumference());
    }
}

public class CircleDemo {
    public static void main(String[] args) {
        Circle c1 = new Circle(7);
        Circle c2 = new Circle(3.5);

        c1.displayDetails();
        System.out.println();
        c2.displayDetails();
    }
}
