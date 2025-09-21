import java.util.*;
public class AttendanceTracker1 {
    public static Map<String, Integer> calculateAttendance(List<String>... days) {
        Map<String, Integer> attendance = new HashMap<>();
        for (List<String> day : days) {
            for (String student : day) {
                attendance.put(student, attendance.getOrDefault(student, 0) + 1);
            }
        }
        return attendance;
    }

    public static void main(String[] args) {
        List<String> day1 = Arrays.asList("Aman", "Neha", "Ravi");
        List<String> day2 = Arrays.asList("Neha", "Ravi", "Simran");
        List<String> day3 = Arrays.asList("Aman", "Ravi");
        Map<String, Integer> result = calculateAttendance(day1, day2, day3);

        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            System.out.println(entry.getKey() + " attended " + entry.getValue() + " days");
        }
    }
}
