import java.util.Scanner;

public class HandshakeCalculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numberOfStudents;

        System.out.println("Enter the number of students (N):");
        numberOfStudents = input.nextInt();

        long handshakes = (long) numberOfStudents * (numberOfStudents - 1) / 2;

        System.out.println("The maximum number of possible handshakes among " + numberOfStudents + " students is " + handshakes);

        input.close();
    }
}
