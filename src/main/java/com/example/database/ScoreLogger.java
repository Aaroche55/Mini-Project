package com.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ScoreLogger {

    private static final String DB_URL = "jdbc:sqlite:quiz.db";

    public static void log_score(String username, String quiz_mode, int score, String difficulty) {
        // Check for the quiz_mode and set difficulty if it's 'quickfire'
        if ("quickfire".equalsIgnoreCase(quiz_mode)) {
            difficulty = "Quickfire"; // Or you can use "N/A" if you prefer
        }

        String sql = "INSERT INTO scores(username, quiz_mode, score, difficulty) VALUES(?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            pstmt.setString(2, quiz_mode);
            pstmt.setInt(3, score);
            pstmt.setString(4, difficulty);
            pstmt.executeUpdate();

            System.out.println("Score logged successfully!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Test out the log_score function
    public static void main(String[] args) {
        log_score("JohnDoe", "quickfire", 85, null);       // For quickfire mode
        log_score("JaneDoe", "ByDifficulty", 90, "NOVICE"); // For ByDifficulty mode
    }
}
