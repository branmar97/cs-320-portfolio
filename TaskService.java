
import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private final Map<String, Task> taskMap = new HashMap<>();

    public void addTask(Task task) {
        // Validate task ID uniqueness before adding
        if (taskMap.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Task with ID " + task.getTaskId() + " already exists.");
        }

        taskMap.put(task.getTaskId(), task);
    }

    public void deleteTask(String taskId) {
        taskMap.remove(taskId);
    }

    public void updateTaskName(String taskId, String newName) {
        Task task = taskMap.get(taskId);
        if (task != null) {
            task.setName(newName);
        }
    }

    public void updateTaskDescription(String taskId, String newDescription) {
        Task task = taskMap.get(taskId);
        if (task != null) {
            task.setDescription(newDescription);
        }
    }

    public Task getTask(String taskId) {
        return taskMap.get(taskId);
    }
}
