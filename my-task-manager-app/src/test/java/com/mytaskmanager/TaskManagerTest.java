
package com.mytaskmanager;

        import org.junit.jupiter.api.Test;
        import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskManagerTest {
    @Test
    public void testAddTask() {
        TaskManager taskManager = new TaskManager();
        Task task = new Task(2, "Test Task");
        try {
            taskManager.addTask(task);
            // Perform assertions to verify the task was added
            // You can retrieve the task from the database and check its properties
            // For simplicity, we will check for success (no exceptions).
        } catch (Exception e) {
            // Fail the test if any exception occurs
            e.printStackTrace();
            assertEquals(true, false);
        }
    }
}
