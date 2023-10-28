package com.example.calculations;

import java.util.List;

import com.example.utilities.ScoreUtil;

public class StandardDeviationCalculator {

    public static double get_standardDeviation(String username) {
        List<Integer> scores = ScoreUtil.fetchUserScores(username);
        double mean = MeanCalculator.get_mean(username);
        double variance = 0;

        for (int score : scores) {
            variance += Math.pow(score - mean, 2);
        }

        return Math.sqrt(variance / scores.size());
    }
}
