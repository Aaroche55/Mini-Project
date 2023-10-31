package com.example.gui;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

import com.example.database.ScoreLogger;
import com.example.quiz.QuizLogic;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NoviceGUI {
    // Declare 'i' as a class-level field to maintain its state
    @SuppressWarnings("unused")
    private static int i = 0;
    private static int score = 0;
    private static boolean quizStarted = false;
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
           createAndShowGUI();
       });
   }
   public static void createAndShowGUI(){

    JFrame noviceFrame = new JFrame("Novice");
    noviceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    noviceFrame.setSize(1500, 750); // Adjusted size
    noviceFrame.setLayout(new BorderLayout());
    noviceFrame.setVisible(true);

    // Center the frame on the screen
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (screenSize.width - noviceFrame.getWidth()) / 2;
    int y = (screenSize.height - noviceFrame.getHeight()) / 2;
    noviceFrame.setLocation(x, y);

    //Panel for the form
    JPanel novicePanel = new JPanel();
    novicePanel.setLayout(new GridLayout(3, 1, 10, 10)); // Set layout to null (absolute positioning)
    novicePanel.setBackground(Color.LIGHT_GRAY); //set background panel

    // Create a label to display questions from QuizManager
    JTextArea textAreaQ = new JTextArea();
    textAreaQ.setBounds(-100, 10, 300, 100);
    textAreaQ.setLineWrap(true);
    textAreaQ.setWrapStyleWord(true);
    textAreaQ.setBackground(Color.LIGHT_GRAY);
    textAreaQ.setEditable(false);
    textAreaQ.setFont(new Font("Arial", Font.PLAIN, 24));

    // Create a label to display options from QuizManager
    JTextArea textAreaO = new JTextArea();
    textAreaO.setBounds(10, 10, 250, 300);
    textAreaO.setLineWrap(true);
    textAreaO.setWrapStyleWord(true);
    textAreaO.setBackground(Color.LIGHT_GRAY);
    textAreaO.setEditable(false);
    textAreaO.setFont(new Font("Arial", Font.PLAIN, 24));

    //Create text field for user to enter answer
    JTextField answerField = new JTextField("Please enter answer: A, B, or C");
    answerField.setBounds(160, 110, 300, 20);


    //Start/Submit button to fetch and display next question, and also to submit answer

    JButton startButton = new JButton("Start/Submit");
    startButton.setBackground(Color.BLUE);
    startButton.setForeground(Color.WHITE);
    startButton.setBounds(250, 150, 100, 30);
    startButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent event) {

            if (!quizStarted) {
                // If the quiz hasn't started, set the flag and start the quiz
                quizStarted = true;
                return; // Exit the listener
            } 
            // Check the answer before moving to the next question
            String answer = answerField.getText().toUpperCase();
            try {
                System.out.println("User's answer: " + answer);
                System.out.println("Expected answer: " + QuizLogic.getQuestionsByDifficulty("NOVICE", "answer").get(i).toString());

                if (i < QuizLogic.getQuestionsByDifficulty("NOVICE", "questions").size() && answer.equals(QuizLogic.getQuestionsByDifficulty("NOVICE", "answer").get(i).toString())) {
                    score++;
                }
                i++;
                if (i < QuizLogic.getQuestionsByDifficulty("NOVICE", "questions").size()+1) {
                    textAreaQ.setText("Question: " + QuizLogic.getQuestionsByDifficulty("NOVICE", "questions").get(i-1).toString());
                    textAreaO.setText("Options A, B, C: " + QuizLogic.getQuestionsByDifficulty("NOVICE", "options").get(i-1).toString()); 
                    answerField.setText(""); // Clear the answer field for the next answer    
                }
                else {
                    JOptionPane.showMessageDialog(null, "You have completed the Quickfire Round!\nYour score is: " + score + "/6");
                    ScoreLogger.log_score(loginGUI.getUsername(), "novice", score);
                    noviceFrame.dispose();
                }
            } catch (SQLException e) {
                // Handle the exception here
                e.printStackTrace();
            }
        }
    });
        
    novicePanel.add(textAreaQ);
    novicePanel.add(textAreaO);
    novicePanel.add(startButton);
    novicePanel.add(answerField);

    noviceFrame.add(novicePanel);
    noviceFrame.setVisible(true);
   }
    
}
