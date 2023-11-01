package com.example.utilities;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ScoreUtil {

    private static final String DB_URL = "jdbc:sqlite:quiz.db";
    
    // A method to log a user's score
    public static List<Integer> fetchUserScoresByMode(String username, String mode) {
        List<Integer> scores = new ArrayList<>();
        String sql = "SELECT score FROM scores WHERE username = ? AND quiz_mode = ?";
    
        // Try-with-resources block to automatically close the connection
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, mode);
    
            // Set the values
            ResultSet rs = pstmt.executeQuery();
    
            // Loop through the result set
            while (rs.next()) {
                scores.add(rs.getInt("score"));
            }
    
            // Catch any errors
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } 
        return scores;
    }

    // A method to return a list of all scores
    public static List<Integer> fetchAllScoresByMode(String mode) {
        List<Integer> scores = new ArrayList<>();
        String sql = "SELECT score FROM scores WHERE quiz_mode = ?";
    
        // Try-with-resources block to automatically close the connection
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, mode);
    
            ResultSet rs = pstmt.executeQuery();
    
            // Loop through the result set
            while (rs.next()) {
                scores.add(rs.getInt("score"));
            }
    
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } 
        return scores;
    }

    // A method to return a list of user's scores
    public static List<Integer> fetchUserScores(String username) {
        List<Integer> scores = new ArrayList<>();
        String sql = "SELECT score FROM scores WHERE username = ?";

        // Try-with-resources block to automatically close the connection
        try (Connection conn = DriverManager.getConnection(DB_URL);
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, username);

                ResultSet rs = pstmt.executeQuery();

                // Loop through the result set
                while (rs.next()) {
                    scores.add(rs.getInt("score"));
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        return scores;
    }
}