public class Task {
    private static final int MAX_TASK_ID_LENGTH = 10;
    private static final int MAX_NAME_LENGTH = 20;
    private static final int MAX_DESCRIPTION_LENGTH = 50;

    private final String taskId;
    private String name;
    private String description;

    public Task(String taskId, String name, String description) {
        validateField(taskId, MAX_TASK_ID_LENGTH, "Task ID");
        validateField(name, MAX_NAME_LENGTH, "Name");
        validateField(description, MAX_DESCRIPTION_LENGTH, "Description");

        this.taskId = taskId;
        this.name = name;
        this.description = description;
    }

    // Getters
    public String getTaskId() {
        return taskId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    // Setters
    public void setName(String name) {
        validateField(name, MAX_NAME_LENGTH, "Name");
        this.name = name;
    }

    public void setDescription(String description) {
        validateField(description, MAX_DESCRIPTION_LENGTH, "Description");
        this.description = description;
    }

    // Validation function
    private void validateField(String value, int maxLength, String fieldName) {
        if (value == null || value.length() > maxLength) {
            throw new IllegalArgumentException(fieldName + " must not be null and cannot be longer than " + maxLength + " characters.");
        }
    }
}
