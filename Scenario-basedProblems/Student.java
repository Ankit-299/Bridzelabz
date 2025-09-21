import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

class InvalidGradeException extends Exception {
    public InvalidGradeException(String message) {
        super(message);
    }
}

class Student {
    private String id;
    private String name;
    private Map<String, Integer> grades;

    public Student(String id, String name, Map<String, Integer> grades) {
        this.id = id;
        this.name = name;
        this.grades = grades;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Map<String, Integer> getGrades() {
        return grades;
    }
}

public class StudentGradingSystem {

    private List<Student> students;
    private Set<String> subjects;

    public StudentGradingSystem() {
        this.students = new ArrayList<>();
        this.subjects = new java.util.HashSet<>();
        
        Map<String, Integer> grades1 = new HashMap<>();
        grades1.put("Math", 85);
        grades1.put("Science", 92);
        grades1.put("History", 78);
        students.add(new Student("S001", "Rahul Sharma", grades1));

        Map<String, Integer> grades2 = new HashMap<>();
        grades2.put("Math", 95);
        grades2.put("Science", 88);
        students.add(new Student("S002", "Priya Singh", grades2));

        Map<String, Integer> grades3 = new HashMap<>();
        grades3.put("Science", 65);
        grades3.put("History", 72);
        grades3.put("Math", 89);
        students.add(new Student("S003", "Amit Kumar", grades3));

        Map<String, Integer> grades4 = new HashMap<>();
        grades4.put("Math", 75);
        grades4.put("Science", 82);
        grades4.put("History", 91);
        students.add(new Student("S004", "Neha Gupta", grades4));

        subjects.add("Math");
        subjects.add("Science");
        subjects.add("History");
    }
    
    private void validateGrades(Map<String, Integer> grades) throws InvalidGradeException {
        for (Integer grade : grades.values()) {
            if (grade < 0 || grade > 100) {
                throw new InvalidGradeException("Grade 0 aur 100 ke beech mein hona chahiye.");
            }
        }
    }

    public void calculateStudentAverages() {
        System.out.println("\n--- Har Student Ka Total Aur Average Grade ---");
        for (Student student : students) {
            Map<String, Integer> grades = student.getGrades();
            
            if (grades.isEmpty()) {
                System.out.println(student.getName() + " (ID: " + student.getId() + ") ka record incomplete hai. Grades nahi mile.");
                continue;
            }
            
            try {
                validateGrades(grades);
                int total = 0;
                for (int grade : grades.values()) {
                    total += grade;
                }
                double average = (double) total / grades.size();
                System.out.printf("Student: %s (ID: %s) | Total: %d | Average: %.2f\n", student.getName(), student.getId(), total, average);
            } catch (InvalidGradeException e) {
                System.out.println("Error: " + student.getName() + " (ID: " + student.getId() + ") ka grade invalid hai: " + e.getMessage());
            }
        }
    }

    public void calculateHighestGradePerSubject() {
        System.out.println("\n--- Har Subject Ka Highest Grade ---");
        for (String subject : subjects) {
            int highestGrade = -1;
            String topperName = "Nahi mila";
            
            for (Student student : students) {
                Map<String, Integer> grades = student.getGrades();
                if (grades.containsKey(subject)) {
                    try {
                        validateGrades(grades);
                        if (grades.get(subject) > highestGrade) {
                            highestGrade = grades.get(subject);
                            topperName = student.getName();
                        }
                    } catch (InvalidGradeException e) {
                        continue;
                    }
                }
            }
            
            if (highestGrade != -1) {
                System.out.printf("Subject: %-10s | Highest Grade: %d (by %s)\n", subject, highestGrade, topperName);
            } else {
                System.out.printf("Subject: %-10s | Koi record nahi mila.\n", subject);
            }
        }
    }

    public void calculateOverallClassAverage() {
        System.out.println("\n--- Class Ka Overall Average Grade ---");
        double totalGrades = 0;
        int gradeCount = 0;
        
        for (Student student : students) {
            Map<String, Integer> grades = student.getGrades();
            if (!grades.isEmpty()) {
                try {
                    validateGrades(grades);
                    for (int grade : grades.values()) {
                        totalGrades += grade;
                    }
                    gradeCount += grades.size();
                } catch (InvalidGradeException e) {
                    continue;
                }
            }
        }
        
        if (gradeCount > 0) {
            double classAverage = totalGrades / gradeCount;
            System.out.printf("Class ka overall average hai: %.2f\n", classAverage);
        } else {
            System.out.println("Koi grades nahi mile class average calculate karne ke liye.");
        }
    }

    public static void main(String[] args) {
        StudentGradingSystem gradingSystem = new StudentGradingSystem();
        
        gradingSystem.calculateStudentAverages();
        
        gradingSystem.calculateHighestGradePerSubject();
        
        gradingSystem.calculateOverallClassAverage();

        System.out.println("\n--- Testing invalid input handling ---");
        Map<String, Integer> invalidGrades = new HashMap<>();
        invalidGrades.put("Math", 105);
        invalidGrades.put("Science", 90);
        gradingSystem.students.add(new Student("S005", "Pooja", invalidGrades));
        gradingSystem.calculateStudentAverages();
    }
}
