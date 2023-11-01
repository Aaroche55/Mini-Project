package com.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

public class ScoreLogger {

    private static final String DB_URL = "jdbc:sqlite:quiz.db";

    // A method to log a user's score
    public static void log_score(String username, String quiz_mode, int score) {
    // Check that quiz_mode is one of the expected values
    if (!Arrays.asList("quickfire", "novice", "intermediate", "advanced").contains(quiz_mode)) {
        System.out.println("Invalid quiz mode provided.");
        return;
    }

    // SQL statement to insert a new score into the scores table
    String sql = "INSERT INTO scores(username, quiz_mode, score) VALUES(?, ?, ?)";

    // Try-with-resources block to automatically close the connection
    try (Connection conn = DriverManager.getConnection(DB_URL);
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
        // Set the values
        pstmt.setString(1, username);
        pstmt.setString(2, quiz_mode);
        pstmt.setInt(3, score);
        pstmt.executeUpdate();

        System.out.println("Score logged successfully!");

    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}


    // Test out the log_score function
    public static void main(String[] args) {
        log_score("Jane", "advanced", 75);    
        log_score("Jane", "quickfire", 80);    
        log_score("Jane", "intermediate", 90);    
    }
}
