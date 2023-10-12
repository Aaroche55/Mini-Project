

import java.util.Scanner;


public class Quiz {
    public static void main(String[] args) throws Exception {
        // Creating arrays
                 // create array of questions and options
            //format - one string for each question 
                // initial question
                    // (a) option 1
                    // (b) option 2 
                    // (c) option 3

                // new question 
                    // (a) option 1
                    // (b) option 2
                    // (c) option 3
        String[] questions = new String[6];

        questions[0] = "Which of the following is a prime number\n  a. 4\n  b. 9\n  c. 13";
        questions[1] = "If a set has 5 elements, how many subsets does it have?\n  a. 5\n  b. 10\n  c. 32";
        questions[2] = "Which of the following is not a type of computer memory?\n  a. RAM\n  b. CPU\n  c. ROM";
        questions[3] = "In which part of the computer is data processed?\n  a. Hard Drive\n  b. RAM\n  c. CPU";
        questions[4] = "Which of the following is considered a high-level programming language?\n  a. Machine Language\n  b. Python\n  c. Assembly Language";
        questions[5] = "What does the acronym 'URL' stand for?\n  a. Universal Resource Locator\n  b. Unified Retrieval Logic\n  c. Uniform Resource Locator";
        
        // create array of answers - same index
            // format 
                // letter

        char[] answers = new char[6];
        answers[0]= 'c';
        answers[1]= 'c';
        answers[2]= 'b';
        answers[3]= 'c';
        answers[4]= 'b';
        answers[5]= 'c';

        // User Interation
        Scanner scanner = new Scanner(System.in);

        // ask username 
        System.out.print("Enter your username: ");
        String username = scanner.next();
        // ask password
        System.out.print("Enter your password: ");
        String password = scanner.next();

        // Print Welcome 
        // Learn / Test
            // if statement - if t- call test 

            // return score in the end

        if (username instanceof String || password instanceof String) {
            System.out.println("\nWelcome!\n");
            System.out.print("Do you want to learn or test? ");
            
            String mode = scanner.next();

            if (mode.equals("learn")) {
                learn(questions, answers);
                scanner.close();
                return;
            }

            else {
                int score = test(questions, answers);
                // print feedback 
                System.out.println("Well done you got a score of " + score + "/6");
            }
        }

        scanner.close();
    }
        
    public static void learn(String questions[], char answers[]) {
        // for loop 0 - 17 
        // print the q and answer 
        for (i = 0; i < questions.length; i++) {
          System.out.println(questions[i] + answers[i]);
        }
        // layout
        // Q [i] - adfsdfsd
        // A [i] - adhsdfdsdfsd

        // q [2]
    }
        
   


    
    
    public static int test(String questions[], char answers[]) {
        // create variable for score
        score = 0;
        // create for loop 0-5 (qs)
        // print  qs and options
        for(i = 0; i < 6;i++) {
        	System.out.println(questions[i]);
        	char ans = scanner.nextChar();
        	if(ans = answers[i]) {
        		score++;
        	}	
        }
        //if(score<=2) {
        	//System.out.println("Sucks to suck. \n Score: " + score);
        //}
        //if((score > 2) && (score <= 4)) {
        	//System.out.println("Meh. \n Score: " + score);
        //}
        //if((score == 5)) {
        	//System.out.println("So Close. \n Score: " + score);
        //}
        //if((score == 6)) {
        	//System.out.println("Perfect. \n Score: " + score);
        
        // ask which option chosen
        // if statement
        // if option chosen = correct answer
        // add 1 to tally
        
        
        //return variable 
        return score;
    }
}
