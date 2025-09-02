class Student {
    String name;
    int rollNumber;
    int marks;

    Student(String name, int rollNumber, int marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    public char calculateGrade() {
        if (marks >= 90) return 'A';
        else if (marks >= 75) return 'B';
        else if (marks >= 50) return 'C';
        else if (marks >= 35) return 'D';
        else return 'F';
    }

    public void displayDetails() {
        System.out.println("----- Student Report -----");
        System.out.println("Name       : " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks      : " + marks);
        System.out.println("Grade      : " + calculateGrade());
    }
}

public class StudentReport {
    public static void main(String[] args) {
        Student s1 = new Student("Rahul", 101, 92);
        Student s2 = new Student("Anita", 102, 67);
        Student s3 = new Student("Vikram", 103, 45);

        s1.displayDetails();
        Sy
