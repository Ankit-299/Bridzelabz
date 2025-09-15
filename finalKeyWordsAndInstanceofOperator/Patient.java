class Patient {
    static String hospitalName = "City Hospital";
    private static int totalPatients = 0;

    private final int patientID;
    private String name;
    private int age;
    private String ailment;

    public Patient(int patientID, String name, int age, String ailment) {
        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        totalPatients++;
    }

    public static void getTotalPatients() {
        System.out.println("Total Patients: " + totalPatients);
    }

    public void displayDetails(Object obj) {
        if (obj instanceof Patient) {
            Patient p = (Patient) obj;
            System.out.println("Hospital: " + hospitalName);
            System.out.println("Patient ID: " + p.patientID);
            System.out.println("Name: " + p.name);
            System.out.println("Age: " + p.age);
            System.out.println("Ailment: " + p.ailment);
            System.out.println("----------------------");
        } else {
            System.out.println("Invalid Patient object!");
        }
    }
}

public class HospitalManagementSystem {
    public static void main(String[] args) {
        Patient pt1 = new Patient(1, "Rohan", 30, "Fever");
        Patient pt2 = new Patient(2, "Neha", 25, "Allergy");

        pt1.displayDetails(pt1);
        pt2.displayDetails(pt2);

        String dummy = "Hello";
        pt1.displayDetails(dummy);

        Patient.getTotalPatients();
    }
}
