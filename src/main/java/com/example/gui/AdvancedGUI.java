package com.example.gui;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

import com.example.database.ScoreLogger;
import com.example.quiz.QuizLogic;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdvancedGUI {
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

        JFrame advancedFrame = new JFrame("Advanced");
        advancedFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        advancedFrame.setSize(1500, 750); // Adjusted size
        advancedFrame.setLayout(new BorderLayout());
        advancedFrame.setVisible(true);

        // Center the frame on the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - advancedFrame.getWidth()) / 2;
        int y = (screenSize.height - advancedFrame.getHeight()) / 2;
        advancedFrame.setLocation(x, y);

        // Panel for the form
        JPanel advancedPanel = new JPanel();
        advancedPanel.setLayout(new GridLayout(3, 1, 10, 10)); // Set layout to null (absolute positioning)
        advancedPanel.setBackground(Color.LIGHT_GRAY); // set background panel

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

        // Create text field for user to enter answer
        JTextField answerField = new JTextField("Please enter answer: A, B, or C");
        answerField.setBounds(160, 110, 300, 20);

        // Start/Submit button to fetch and display next question, and also to submit
        // answer
        JButton startButton = new JButton("Start/Submit");
        startButton.setBackground(Color.BLUE);
        startButton.setForeground(Color.WHITE);
        startButton.setBounds(250, 150, 100, 30);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                try {
                    // Check if it's the first click
                    if (firstClick) {
                        // For the first click, just show the question and clear the answer field
                        textAreaQ.setText("Question: "
                                + QuizLogic.getQuestionsByDifficulty("ADVANCED", "questions").get(i).toString());
                        textAreaO.setText("Options A, B, C: "
                                + QuizLogic.getQuestionsByDifficulty("ADVANCED", "options").get(i).toString());
                        answerField.setText(""); // Clear the answer field
                        firstClick = false; // Now it's no longer the first click
                    } else {
                        String answer = answerField.getText().toUpperCase(); // Store the value in answer field
                        
                        // Check if previous answer was correct
                        if (answer.equals(QuizLogic.getQuestionsByDifficulty("ADVANCED", "answer").get(i).toString())) {
                            score++;
                        }
                        
                        i++; // Increment i for the next question
                        // Check if there are more questions
                        if (i < QuizLogic.getQuestionsByDifficulty("ADVANCED", "questions").size()) {
                            // Update text areas for the next question
                            textAreaQ.setText("Question: "
                                    + QuizLogic.getQuestionsByDifficulty("ADVANCED", "questions").get(i).toString());
                            textAreaO.setText("Options A, B, C: "
                                    + QuizLogic.getQuestionsByDifficulty("ADVANCED", "options").get(i).toString());
                            answerField.setText(""); // Clear the answer field
                        } else {
                            // Show the final score and close the frame
                            JOptionPane.showMessageDialog(null,
                                    "You have completed the Novice Round!\nYour score is: " + score + "/" + (i));
                            ScoreLogger.log_score(loginGUI.getUsername(), "advanced", (int) (((double) score / 6) * 100));
                            i = 0;
                            score = 0;
                            advancedFrame.dispose();
                        }
                    }
                } catch (SQLException e) {
                    // Handle the exception here
                    e.printStackTrace();
                }
            }
        });

        advancedPanel.add(textAreaQ);
        advancedPanel.add(textAreaO);
        advancedPanel.add(startButton);
        advancedPanel.add(answerField);

        advancedFrame.add(advancedPanel);
        advancedFrame.setVisible(true);
    }
}
