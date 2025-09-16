// Superclass
abstract class Person {
    private String name;
    private int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters
    public String getName() { return name; }
    public int getAge() { return age; }

    // Abstract method to enforce role display
    public abstract void displayRole();
}

// Teacher subclass
class Teacher extends Person {
    private String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    @Override
    public void displayRole() {
        System.out.println(getName() + " (Age: " + getAge() + ") is a Teacher of " + subject);
    }
}

// Student subclass
class Student extends Person {
    private String grade;

    public Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    @Override
    public void displayRole() {
        System.out.println(getName() + " (Age: " + getAge() + ") is a Student in Grade " + grade);
    }
}

// Staff subclass
class Staff extends Person {
    private String department;

    public Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    @Override
    public void displayRole() {
        System.out.println(getName() + " (Age: " + getAge() + ") is a Staff member in " + department + " department");
    }
}

// Demo
public class SchoolSystemDemo {
    public static void main(String[] args) {
        Person t = new Teacher("Alice", 35, "Math");
        Person s = new Student("Bob", 16, "10th");
        Person st = new Staff("Charlie", 40, "Administration");

        // Polymorphism in action
        t.displayRole();
        s.displayRole();
        st.displayRole();
    }
}
