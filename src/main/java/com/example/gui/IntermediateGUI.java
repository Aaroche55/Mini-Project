package com.example.gui;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

import com.example.database.ScoreLogger;
import com.example.quiz.QuizLogic;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IntermediateGUI {
    // Declare 'i' as a class-level field to maintain its state
    @SuppressWarnings("unused")
    private static int i = 0;
    private static boolean firstClick = true; // To know if it's the first click

    private static int score = 0;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    public static void createAndShowGUI() {

        JFrame intermediateFrame = new JFrame("Intermediate");
        intermediateFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        intermediateFrame.setSize(1500, 750); // Adjusted size
        intermediateFrame.setLayout(new BorderLayout());
        intermediateFrame.setVisible(true);

        // Center the frame on the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - intermediateFrame.getWidth()) / 2;
        int y = (screenSize.height - intermediateFrame.getHeight()) / 2;
        intermediateFrame.setLocation(x, y);

        // Panel for the form
        JPanel intermediatePanel = new JPanel();
        intermediatePanel.setLayout(null); // Set layout to null (absolute positioning)
        intermediatePanel.setBackground(Color.LIGHT_GRAY); // set background panel

        // Create a label to display questions from QuizManager
        JTextArea textAreaQ = new JTextArea();
        textAreaQ.setBounds(50, 100, 650, 100);
        textAreaQ.setLineWrap(true);
        textAreaQ.setWrapStyleWord(true);
        textAreaQ.setBackground(Color.LIGHT_GRAY);
        textAreaQ.setEditable(false);
        textAreaQ.setFont(new Font("Arial", Font.PLAIN, 24));

        // Create a label to display options from QuizManager
        JTextArea textAreaO = new JTextArea();
        textAreaO.setBounds(800, 100, 650, 300);
        textAreaO.setLineWrap(true);
        textAreaO.setWrapStyleWord(true);
        textAreaO.setBackground(Color.LIGHT_GRAY);
        textAreaO.setEditable(false);
        textAreaO.setFont(new Font("Arial", Font.PLAIN, 24));

        // Create text field for user to enter answer
        JTextField answerField = new JTextField("Please enter answer: A, B, or C");
        answerField.setBounds(500, 550, 500, 50);

        // Start/Submit button to fetch and display next question, and also to submit
        // answer
        JButton startButton = new JButton("Start/Submit");
        startButton.setBackground(Color.BLUE);
        startButton.setForeground(Color.WHITE);
        startButton.setBounds(625, 625, 250, 50);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                try {
                    // Check if it's the first click
                    if (firstClick) {
                        // For the first click, just show the question and clear the answer field
                        textAreaQ.setText("Question: "
                                + QuizLogic.getQuestionsByDifficulty("INTERMEDIATE", "questions").get(i).toString());
                        textAreaO.setText("Options A, B, C: "
                                + QuizLogic.getQuestionsByDifficulty("INTERMEDIATE", "options").get(i).toString());
                        answerField.setText(""); // Clear the answer field
                        firstClick = false; // Now it's no longer the first click
                    } else {
                        String answer = answerField.getText().toUpperCase(); // Store the value in answer field
                        
                        // Check if previous answer was correct
                        if (answer.equals(QuizLogic.getQuestionsByDifficulty("INTERMEDIATE", "answer").get(i).toString())) {
                            score++;
                        }
                        
                        i++; // Increment i for the next question
                        // Check if there are more questions
                        if (i < QuizLogic.getQuestionsByDifficulty("INTERMEDIATE", "questions").size()) {
                            // Update text areas for the next question
                            textAreaQ.setText("Question: "
                                    + QuizLogic.getQuestionsByDifficulty("INTERMEDIATE", "questions").get(i).toString());
                            textAreaO.setText("Options [A, B, C]: "
                                    + QuizLogic.getQuestionsByDifficulty("INTERMEDIATE", "options").get(i).toString());
                            answerField.setText(""); // Clear the answer field
                        } else {
                            // Show the final score and close the frame
                            JOptionPane.showMessageDialog(null,
                                    "You have completed the Novice Round!\nYour score is: " + score + "/" + (i));
                            ScoreLogger.log_score(loginGUI.getUsername(), "intermediate", (int) (((double) score / 6) * 100));
                            i = 0;
                            score = 0;
                            intermediateFrame.dispose();
                        }
                    }
                } catch (SQLException e) {
                    // Handle the exception here
                    e.printStackTrace();
                }
            }
        });

         // Add Exit button
         JButton exitButton = new JButton("Exit");
         exitButton.setBackground(Color.RED);
         exitButton.setForeground(Color.WHITE);
         exitButton.setBounds(1200, 625, 250, 50);
         exitButton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent event) {
                 JOptionPane.showMessageDialog(null, "Exiting the round will result in a score of 0.");
                 intermediateFrame.dispose();
             }
         });

        intermediatePanel.add(textAreaQ);
        intermediatePanel.add(textAreaO);
        intermediatePanel.add(startButton);
        intermediatePanel.add(exitButton);
        intermediatePanel.add(answerField);

        intermediateFrame.add(intermediatePanel);
        intermediateFrame.setVisible(true);
    }

}
