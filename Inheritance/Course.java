// Base class (superclass)
abstract class Course {
    private String courseName;
    private int duration; // in hours

    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getDuration() {
        return duration;
    }

    // Template method (can be overridden by subclasses if needed)
    public void displayDetails() {
        System.out.println("Course: " + courseName + ", Duration: " + duration + " hours");
    }
}

// Subclass extending Course
class OnlineCourse extends Course {
    private String platform;
    private boolean isRecorded;

    public OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration); // explicit call to superclass constructor
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    public String getPlatform() {
        return platform;
    }

    public boolean isRecorded() {
        return isRecorded;
    }

    @Override
    public void displayDetails() {
        super.displayDetails(); // reusing behavior of superclass
        System.out.println("Platform: " + platform + ", Recorded: " + isRecorded);
    }
}

// Subclass extending OnlineCourse
class PaidOnlineCourse extends OnlineCourse {
    private double fee;
    private double discount; // percentage

    public PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    public double calculateFinalFee() {
        return fee - (fee * discount / 100);
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Fee: " + fee + ", Discount: " + discount + "%, Final Fee: " + calculateFinalFee());
    }
}

// Demo class
public class CourseHierarchyDemo {
    public static void main(String[] args) {
        Course freeCourse = new OnlineCourse("Intro to Java", 20, "Udemy", true);
        Course paidCourse = new PaidOnlineCourse("Advanced Java", 40, "Coursera", true, 5000, 20);

        // Polymorphism in action
        freeCourse.displayDetails();
        System.out.println("-------------------");
        paidCourse.displayDetails();
    }
}
