package com.example;

import com.example.calculations.MeanCalculator;
import com.example.calculations.MedianCalculator;
import com.example.calculations.StandardDeviationCalculator;

public class Main {
    public static void main(String[] args) {
        System.out.println(MeanCalculator.get_mean("JaneDoe"));
        System.out.println(StandardDeviationCalculator.get_standardDeviation("JohnDoe"));
        System.out.println(MedianCalculator.get_median("JohnDoe"));
    }
        
}