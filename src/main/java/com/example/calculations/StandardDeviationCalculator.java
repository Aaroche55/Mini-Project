package com.example.calculations;

import java.util.List;

import com.example.utilities.ScoreUtil;

public class StandardDeviationCalculator {
    // Returns an array of doubles containing the user's standard deviation and the standard deviation of all users for each mode
    public static double[] get_standardDeviation(String username) {
        double[] std_devs = new double[8];
        String[] modes = {"novice", "intermediate", "advanced", "quickfire"};
        int mode_counter = 0;
        for (int i = 0; i < 8; i += 2) {
            std_devs[i] = getUsersStdDevByMode(username, modes[mode_counter]);
            std_devs[i + 1] = getAllUsersStdDevByMode(modes[mode_counter]);
            mode_counter++;
        }
        return std_devs;
    }

    // Returns an array of doubles containing the user's standard deviation
    public static double getUsersStdDevByMode(String username, String mode) {
        List<Integer> scores = ScoreUtil.fetchUserScoresByMode(username, mode);
        return calculateStdDev(scores);
    }

    // Returns an array of doubles containing all user's standard deviation
    public static double getAllUsersStdDevByMode(String mode) {
        List<Integer> scores = ScoreUtil.fetchAllScoresByMode(mode);
        return calculateStdDev(scores);
    }
    
    // Returns a double of the standard deviation based on the list of scores
    private static double calculateStdDev(List<Integer> scores) {
        int n = scores.size();
        if (n <= 1) return 0;
        
        double mean = scores.stream().mapToDouble(i -> i).average().orElse(0);
        double variance = scores.stream().mapToDouble(i -> (i - mean) * (i - mean)).sum() / n;
        return Math.sqrt(variance);
    }
}
