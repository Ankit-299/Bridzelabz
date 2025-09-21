import java.util.Set;
import java.util.TreeSet;

public class MyToDoList {

    private Set<String> tasks = new TreeSet<>();

    public void addTask(String taskName) {
        tasks.add(taskName);
        System.out.println("Added: " + taskName);
    }

    public void removeTask(String taskName) {
       
        if (tasks.remove(taskName)) {
            System.out.println("Removed: " + taskName);
        } else {
            System.out.println("Error: '" + taskName + "' task mila hi nahi.");
        }
    }

    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("List khali hai.");
        } else {
            System.out.println("My Tasks (Sorted):");
            for (String task : tasks) {
                System.out.println("- " + task);
            }
        }
    }
}
