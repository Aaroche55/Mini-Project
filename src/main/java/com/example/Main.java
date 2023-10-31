package com.example;

import com.example.quiz.QuizLogic;

public class Main {
    public static void main(String[] args) throws Exception {

        // for (int i = 0; i < 8 ; i++)
        // {
        //     System.out.println(MeanCalculator.get_mean("JohnDoe")[i]);
        //     System.out.println(StandardDeviationCalculator.get_standardDeviation("JohnDoe")[i]);
        //     System.out.println(MedianCalculator.get_median("JohnDoe")[i]);
        //     System.out.println();
        // }

        System.out.println(QuizLogic.get_questions().get(0));
        System.out.println(QuizLogic.get_options().get(0));
        System.out.println(QuizLogic.get_answers().get(0));
        
        
    }
}