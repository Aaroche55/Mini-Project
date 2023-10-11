
public class Quiz {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
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


        // create array of answers - same index
            // format 
                // letter

        // User Interation

        // ask username 
        // ask password

        // Print Welcome 
        // Learn / Test
            // if statement - if t- call test 

            // return score in the end
        }
        
        public static void learn(String questions[], String answers[]) {
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
    
    public static int test(String questions[], String answers[]) {
        // create variable for score
        score = 0
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
