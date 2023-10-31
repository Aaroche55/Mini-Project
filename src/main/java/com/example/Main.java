package com.example;

import com.example.calculations.MeanCalculator;
import com.example.calculations.MedianCalculator;
//import com.example.authentication.Authentication;
import com.example.leaderboard.Leaderboard;

// import com.example.calculations.MeanCalculator;
// import com.example.calculations.MedianCalculator;
import com.example.calculations.StandardDeviationCalculator;

public class Main {
    public static void main(String[] args) throws Exception {

        // for (int i = 0; i < 8 ; i++)
        // {
        //     System.out.println(MeanCalculator.get_mean("JohnDoe")[i]);
        //     System.out.println(StandardDeviationCalculator.get_standardDeviation("JohnDoe")[i]);
        //     System.out.println(MedianCalculator.get_median("JohnDoe")[i]);
        //     System.out.println();
        // }

        Leaderboard.printLeaderboard();

        
    }
}