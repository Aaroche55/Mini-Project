package com.example.calculations;

import java.util.Collections;
import java.util.List;

import com.example.utilities.ScoreUtil;

public class MedianCalculator {

    public static double get_median(String username) {
        List<Integer> scores = ScoreUtil.fetchUserScores(username);
        Collections.sort(scores);
        
        int middle = scores.size() / 2;
        if (scores.size() % 2 == 1) {
            return scores.get(middle);
        } else {
            return (scores.get(middle - 1) + scores.get(middle)) / 2.0;
        }
    }
}
