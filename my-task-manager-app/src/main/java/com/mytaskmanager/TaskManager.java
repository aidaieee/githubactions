package com.mytaskmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class TaskManager {
    private Connection connection;

    public TaskManager() {
        try {
            // Connect to an SQLite database file (create if it doesn't exist)
            connection = DriverManager.getConnection("jdbc:sqlite:mydb.db");
            createTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS tasks (id INT PRIMARY KEY, name VARCHAR(255))";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.executeUpdate();
    }

        public void addTask(Task task) throws SQLException {
            if (taskExists(task.getId())) {
                String sql = "INSERT INTO tasks (id, name) VALUES (?, ?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, task.getId());
                statement.setString(2, task.getName());
                statement.executeUpdate();
            } else {
                String sql = "INSERT INTO tasks (id, name) VALUES (?, ?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, task.getId());
                statement.setString(2, task.getName());
                statement.executeUpdate();
            }
        }


    private boolean taskExists(int taskId) throws SQLException {
        String sql = "SELECT id FROM tasks WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, taskId);
        ResultSet resultSet = statement.executeQuery();
        return resultSet.next(); // Returns true if a result is found
    }

    public void clearDatabase() throws SQLException {
        String sql = "DELETE FROM tasks";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.executeUpdate();
    }




}
