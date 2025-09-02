class Employee {
    String name;
    int id;
    double salary;

    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public void displayDetails() {
        System.out.println("----- Employee Details -----");
        System.out.println("Name   : " + name);
        System.out.println("ID     : " + id);
        System.out.println("Salary : " + salary);
    }
}

public class EmployeeDemo {
    public static void main(String[] args) {
        Employee e1 = new Employee("Rahul Sharma", 101, 45000);
        Employee e2 = new Employee("Anita Verma", 102, 55000);

        e1.displayDetails();
        System.out.println();
        e2.displayDetails();
    }
}
