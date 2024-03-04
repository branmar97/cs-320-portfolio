import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {

    @Test
    public void testAddTask() {
        TaskService taskService = new TaskService();
        Task task1 = new Task("1", "Task 1", "Description 1");
        Task task2 = new Task("2", "Task 2", "Description 2");

        taskService.addTask(task1);
        taskService.addTask(task2);

        assertEquals(task1, taskService.getTask("1"));
        assertEquals(task2, taskService.getTask("2"));
    }

    @Test
    public void testAddTaskDuplicateID() {
        TaskService taskService = new TaskService();
        Task task1 = new Task("1", "Task 1", "Description 1");
        Task task2 = new Task("1", "Task 2", "Description 2");  // Duplicate ID

        taskService.addTask(task1);

        assertThrows(IllegalArgumentException.class, () -> taskService.addTask(task2));
    }

    @Test
    public void testDeleteTask() {
        TaskService taskService = new TaskService();
        Task task = new Task("1", "Task 1", "Description 1");

        taskService.addTask(task);
        taskService.deleteTask("1");

        assertNull(taskService.getTask("1"));
    }

    @Test
    public void testUpdateTaskName() {
        TaskService taskService = new TaskService();
        Task task = new Task("1", "Task 1", "Description 1");

        taskService.addTask(task);
        taskService.updateTaskName("1", "New Task Name");

        assertEquals("New Task Name", taskService.getTask("1").getName());
    }

    @Test
    public void testUpdateTaskDescription() {
        TaskService taskService = new TaskService();
        Task task = new Task("1", "Task 1", "Description 1");

        taskService.addTask(task);
        taskService.updateTaskDescription("1", "New Task Description");

        assertEquals("New Task Description", taskService.getTask("1").getDescription());
    }
}
