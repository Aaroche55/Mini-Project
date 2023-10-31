package com.example.leaderboard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

import org.apache.commons.lang3.tuple.Pair;

import com.example.calculations.MeanCalculator;


public class Leaderboard {
    private static final String DB_URL = "jdbc:sqlite:quiz.db";

    public static List<String> return_users() {
        List<String> names = new ArrayList<>();
        String sql = "SELECT username FROM users";
    
        try (Connection conn = DriverManager.getConnection(DB_URL);
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
    
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                names.add(rs.getString("username"));
            }
    
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 

        return names;
    }

    public static List<Pair<String, Double>> createLeaderboard() {
        List<Pair<String, Double>> pairs = new ArrayList<>();
        List<String> names = return_users();

        double temp_mean;

        for (String name : names) {
            temp_mean = MeanCalculator.getUserMean(name);
            pairs.add(Pair.of(name, temp_mean));
        }

        Collections.sort(pairs, new Comparator<Pair<String, Double>>() {
            @Override
            public int compare(Pair<String, Double> o1, Pair<String, Double> o2) {
                return o2.getValue().compareTo(o1.getValue()); // Descending order
            }
        });

        return pairs;
    }

    public static void printLeaderboard() {
        List<Pair<String, Double>> pairs = createLeaderboard();

        String key;
        double value;
        for (int i = 0; i < return_users().size(); i++) {
            key = pairs.get(i).getKey();
            value = pairs.get(i).getValue();
            System.out.println(key);
            System.out.println(value);
            System.out.println();
        }
    }
}

