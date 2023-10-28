package com.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Reset {
    
    private static final String DB_URL = "jdbc:sqlite:quiz.db";
    
    public static void resetDatabase() {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {
            
            stmt.execute("DELETE FROM scores");
            stmt.execute("DELETE FROM questions");
            stmt.execute("DELETE FROM users");
            
            System.out.println("All data removed!");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        resetDatabase();
    }
}
