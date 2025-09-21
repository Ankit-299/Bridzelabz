import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AttendanceTracker {

    public static Map<String, Integer> calculateAttendance(List<List<String>> allDaysAttendance) {
        Map<String, Integer> attendanceCount = new HashMap<>();

        for (List<String> dailyList : allDaysAttendance) {
           
            for (String student : dailyList) {
                
                attendanceCount.put(student, attendanceCount.getOrDefault(student, 0) + 1);
            }
        }
        return attendanceCount;
    }
}
