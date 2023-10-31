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

        for (int i = 0; i < 6; i++){
            System.out.println(QuizLogic.get_questions().get(i));
            System.out.println(QuizLogic.get_options().get(i));
            System.out.println(QuizLogic.get_answers().get(i));
            System.out.println();
        }

        
    }
}