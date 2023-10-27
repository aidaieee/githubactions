package com.mytaskmanager;

import java.sql.SQLException;

public class MainApp {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Task task = new Task(1, "Complete Java Project");
        try {
            taskManager.addTask(task);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception here, e.g., log the error or provide user feedback.
        }
    }
}
