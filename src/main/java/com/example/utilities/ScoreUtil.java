package com.example.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class ScoreUtil {

    private static final String DB_URL = "jdbc:sqlite:quiz.db";

    public static List<Integer> fetchUserScores(String username) {
        List<Integer> scores = new ArrayList<>();
        String sql = "SELECT score FROM scores WHERE username = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                scores.add(rs.getInt("score"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return scores;
    }
}
