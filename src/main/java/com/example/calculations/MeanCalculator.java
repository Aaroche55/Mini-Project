package com.example.calculations;
import java.util.List;

import com.example.utilities.ScoreUtil;

public class MeanCalculator {
    // Returns an array of doubles containing the user's mean and the mean of all users for each mode
    public static double[] get_mean(String username) {
        double[] means = new double[8];
        String[] modes = {"novice", "intermediate", "advanced", "quickfire"};
        int mode_counter = 0;
        for (int i = 0; i < 8; i += 2) {
            means[i] = getUsersMeanByMode(username, modes[mode_counter]);
            means[i + 1] = getAllUsersMeanByMode(modes[mode_counter]);
            mode_counter ++;
        }
        return means;
    }

    // Returns an array of doubles containing the user's mean and the mean of all users for each mode
    public static double getUsersMeanByMode(String username, String mode) {
        List<Integer> scores = ScoreUtil.fetchUserScoresByMode(username, mode);  // Fetch scores using ScoreUtil
    
        if (scores.size() == 0) return 0;
    
        double sum = 0;
        for (int score : scores) {
            sum += score;
        }
    
        return sum / scores.size();
    }

    // Returns an array of doubles containing the user's mean and the mean of all users for each mode
    public static double getAllUsersMeanByMode(String mode) {
        List<Integer> scores = ScoreUtil.fetchAllScoresByMode(mode);  // Fetch scores using ScoreUtil
    
        if (scores.size() == 0) return 0;
    
        double sum = 0;
        for (int score : scores) {
            sum += score;
        }
    
        return sum / scores.size();
    }

    // Returns an array of doubles containing the user's mean and the mean of all users for each mode
    public static double getUserMean(String username) {
        List<Integer> scores = ScoreUtil.fetchUserScores(username);  // Fetch scores using ScoreUtil
    
        if (scores.size() == 0) return 0;
    
        double sum = 0;
        for (int score : scores) {
            sum += score;
        }
    
        return sum / scores.size();
    }
}
