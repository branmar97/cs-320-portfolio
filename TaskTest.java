import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TaskTest {

    @Test
    public void testCreateTask() {
        Task task = new Task("1", "Task 1", "Description 1");

        assertEquals("1", task.getTaskId());
        assertEquals("Task 1", task.getName());
        assertEquals("Description 1", task.getDescription());
    }

    @Test
    public void testInvalidTaskId() {
        assertThrows(IllegalArgumentException.class, () -> new Task(null, "Task 1", "Description 1"));
    }

    @Test
    public void testInvalidName() {
        assertThrows(IllegalArgumentException.class, () -> new Task("1", null, "Description 1"));
    }

    @Test
    public void testInvalidDescription() {
        assertThrows(IllegalArgumentException.class, () -> new Task("1", "Task 1", null));
    }

    @Test
    public void testLongTaskId() {
        assertThrows(IllegalArgumentException.class, () -> new Task("12345678901", "Task 1", "Description 1"));
    }

    @Test
    public void testLongName() {
        assertThrows(IllegalArgumentException.class, () -> new Task("1", "ThisNameIsTooLongToBeValid", "Description 1"));
    }

    @Test
    public void testLongDescription() {
        assertThrows(IllegalArgumentException.class, () -> new Task("1", "Task 1", "ThisDescriptionIsTooLongToBeValidThisDescriptionIsTooLongToBeValid"));
    }
}
