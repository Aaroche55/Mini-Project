package com.example.calculations;
import java.util.Collections;
import java.util.List;
import com.example.utilities.ScoreUtil;

public class MedianCalculator {
    // Returns an array of doubles containing the user's median and the median of all users for each mode
    public static double[] get_median(String username) {
        double[] medians = new double[8];
        String[] modes = {"novice", "intermediate", "advanced", "quickfire"};
        int mode_counter = 0;
        for (int i = 0; i < 8; i += 2) {
            medians[i] = getUsersMedianByMode(username, modes[mode_counter]);
            medians[i + 1] = getAllUsersMedianByMode(modes[mode_counter]);
            mode_counter ++;
        }
        return medians;
    }
    // Returns an array of doubles containing the user's median and the median of all users for each mode
    public static double getUsersMedianByMode(String username, String mode) {
        List<Integer> scores = ScoreUtil.fetchUserScoresByMode(username, mode);
        Collections.sort(scores);

        int n = scores.size();
        if (n == 0) return 0;
        
        if (n % 2 != 0)
            return scores.get(n / 2);
        else
            return (scores.get((n - 1) / 2) + scores.get(n / 2)) / 2.0;
    }
    // Returns an array of doubles containing the user's median and the median of all users for each mode
    public static double getAllUsersMedianByMode(String mode) {
        List<Integer> scores = ScoreUtil.fetchAllScoresByMode(mode);
        Collections.sort(scores);

        int n = scores.size();
        if (n == 0) return 0;

        if (n % 2 != 0)
            return scores.get(n / 2);
        else
            return (scores.get((n - 1) / 2) + scores.get(n / 2)) / 2.0;
    }
}
