import java.util.ArrayList;
import java.util.List;

// Custom exception for negative or invalid salary
class InvalidSalaryException extends Exception {
    public InvalidSalaryException(String message) {
        super(message);
    }
}

// Employee ki details store karne ke liye class
class Employee {
    private String name;
    private String id;
    private String department;
    private double basicSalary;

    public Employee(String name, String id, String department, double basicSalary) throws InvalidSalaryException {
        if (basicSalary < 0) {
            throw new InvalidSalaryException("Basic salary negative nahi ho sakti.");
        }
        this.name = name;
        this.id = id;
        this.department = department;
        this.basicSalary = basicSalary;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getDepartment() {
        return department;
    }

    public double getBasicSalary() {
        return basicSalary;
    }
}

// Payroll system ko manage karne ke liye main class
public class EmployeePayrollSystem {

    private List<Employee> employees;

    public EmployeePayrollSystem() {
        this.employees = new ArrayList<>();
    }

    // Naya employee add karne ke liye method
    public void addEmployee(String name, String id, String department, double basicSalary) {
        try {
            Employee newEmployee = new Employee(name, id, department, basicSalary);
            employees.add(newEmployee);
        } catch (InvalidSalaryException e) {
            System.err.println("Error: " + name + " ka record add nahi hua. " + e.getMessage());
        }
    }

    // Gross salary calculate karne ke liye method (basic + allowance)
    private double calculateGrossSalary(double basicSalary) {
        double allowances = basicSalary * 0.20; // Example: 20% allowance
        return basicSalary + allowances;
    }

    // Tax deduct karne ke liye method based on salary brackets
    private double calculateTax(double grossSalary) {
        if (grossSalary <= 50000) {
            return 0; // No tax
        } else if (grossSalary <= 100000) {
            return grossSalary * 0.10; // 10% tax
        } else {
            return grossSalary * 0.20; // 20% tax
        }
    }

    // Saare employees ke liye annual salary report generate karne ke liye method
    public void generateAnnualReport() {
        System.out.println("--- Employee Annual Salary Report ---");
        
        if (employees.isEmpty()) {
            System.out.println("Koi employee record nahi hai.");
            return;
        }

        for (Employee emp : employees) {
            System.out.println("--------------------------------------");
            System.out.println("Name: " + emp.getName());
            System.out.println("ID: " + emp.getId());
            System.out.println("Department: " + emp.getDepartment());
            
            try {
                // Check for incomplete records (e.g., basic salary)
                if (emp.getBasicSalary() < 0) {
                    throw new InvalidSalaryException("Record incomplete hai, salary missing.");
                }

                double monthlyGross = calculateGrossSalary(emp.getBasicSalary());
                double annualGross = monthlyGross * 12;

                double annualTax = calculateTax(annualGross);
                double annualNet = annualGross - annualTax;
                
                System.out.printf("Basic Salary: %.2f\n", emp.getBasicSalary());
                System.out.printf("Monthly Gross Salary: %.2f\n", monthlyGross);
                System.out.printf("Annual Gross Salary: %.2f\n", annualGross);
                System.out.printf("Annual Tax Deducted: %.2f\n", annualTax);
                System.out.printf("Annual Net Salary: %.2f\n", annualNet);

            } catch (InvalidSalaryException e) {
                System.err.println("Error calculating salary for " + emp.getName() + ": " + e.getMessage());
            }
        }
        System.out.println("--------------------------------------");
    }

    public static void main(String[] args) {
        EmployeePayrollSystem payroll = new EmployeePayrollSystem();

        // Employees add kar rahe hain
        payroll.addEmployee("Rahul Kumar", "E001", "Engineering", 75000.00);
        payroll.addEmployee("Priya Sharma", "E002", "Marketing", 95000.00);
        payroll.addEmployee("Amit Singh", "E003", "Finance", 120000.00);
        
        // Invalid data ko handle kar rahe hain
        payroll.addEmployee("Sneha Gupta", "E004", "HR", -50000.00);

        // Annual report generate kar rahe hain
        payroll.generateAnnualReport();
    }
}
