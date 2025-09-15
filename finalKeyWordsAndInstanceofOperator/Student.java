class Student {
    static String universityName = "ABC University";
    private static int totalStudents = 0;

    private final int rollNumber;
    private String name;
    private String grade;

    public Student(int rollNumber, String name, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.grade = grade;
        totalStudents++;
    }

    public static void displayTotalStudents() {
        System.out.println("Total Students: " + totalStudents);
    }

    public void displayDetails(Object obj) {
        if (obj instanceof Student) {
            Student s = (Student) obj;
            System.out.println("University: " + universityName);
            System.out.println("Roll Number: " + s.rollNumber);
            System.out.println("Name: " + s.name);
            System.out.println("Grade: " + s.grade);
            System.out.println("----------------------");
        } else {
            System.out.println("Invalid Student object!");
        }
    }

    public void updateGrade(Object obj, String newGrade) {
        if (obj instanceof Student) {
            Student s = (Student) obj;
            s.grade = newGrade;
            System.out.println("Grade updated for " + s.name);
        } else {
            System.out.println("Cannot update grade. Not a Student object!");
        }
    }
}

public class StudentManagementSystem {
    public static void main(String[] args) {
        Student st1 = new Student(101, "Aman", "A");
        Student st2 = new Student(102, "Riya", "B");

        st1.displayDetails(st1);
        st2.displayDetails(st2);

        st1.updateGrade(st2, "A+");
        st2.displayDetails(st2);

        String dummy = "Hello";
        st1.displayDetails(dummy);

        Student.displayTotalStudents();
    }
}
