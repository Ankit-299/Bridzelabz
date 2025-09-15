class Employee {
    static String companyName = "Tech Solutions Pvt. Ltd.";
    private static int totalEmployees = 0;

    private final int id;
    private String name;
    private String designation;

    public Employee(int id, String name, String designation) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        totalEmployees++;
    }

    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    public void displayDetails(Object obj) {
        if (obj instanceof Employee) {
            Employee e = (Employee) obj;
            System.out.println("Company: " + companyName);
            System.out.println("Employee ID: " + e.id);
            System.out.println("Name: " + e.name);
            System.out.println("Designation: " + e.designation);
            System.out.println("----------------------");
        } else {
            System.out.println("Not a valid Employee object!");
        }
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Employee e1 = new Employee(101, "Ankit", "Developer");
        Employee e2 = new Employee(102, "Riya", "Manager");

        e1.displayDetails(e1);
        e2.displayDetails(e2);

        String dummy = "Hello";
        e1.displayDetails(dummy);

        Employee.displayTotalEmployees();
    }
}
