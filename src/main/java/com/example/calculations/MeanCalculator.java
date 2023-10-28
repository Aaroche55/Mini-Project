package com.example.calculations;

import java.util.List;

import com.example.utilities.ScoreUtil;

public class MeanCalculator {

    public static double get_mean(String username) {
        List<Integer> scores = ScoreUtil.fetchUserScores(username);
        if (scores.size() == 0) return 0;
        
        double sum = 0;
        for (int score : scores) {
            sum += score;
        }
        
        return sum / scores.size();
    }
}
