package com.example.gui;

import com.example.database.ScoreLogger;
import com.example.quiz.QuizLogic;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuckfireGUI {
    // Declare 'i' as a class-level field to maintain its state
    @SuppressWarnings("unused")
    private static int i = 0;
    private static int score = 0;
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
           createAndShowGUI();
       });
   }
   public static void createAndShowGUI(){

    JFrame quickfireFrame = new JFrame("Quickfire Round");
    quickfireFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    quickfireFrame.setSize(1500, 750); // Adjusted size
    quickfireFrame.setLayout(new BorderLayout());
    quickfireFrame.setVisible(true);

    // Center the frame on the screen
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (screenSize.width - quickfireFrame.getWidth()) / 2;
    int y = (screenSize.height - quickfireFrame.getHeight()) / 2;
    quickfireFrame.setLocation(x, y);

    //Panel for the form
    JPanel quickfirePanel = new JPanel();
    quickfirePanel.setLayout(new GridLayout(3, 1, 10, 10)); // Set layout to null (absolute positioning)
    quickfirePanel.setBackground(Color.LIGHT_GRAY); //set background panel

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
        public void actionPerformed(ActionEvent e) {
            // Check the answer before moving to the next question
            String answer = answerField.getText().toUpperCase();
            if (i < QuizLogic.get_questions().size() && answer.equals(QuizLogic.get_answers().get(i).toString())) {
                score++;
            }
            
            i++;
            
            if (i < QuizLogic.get_questions().size()+1) {
                textAreaQ.setText("Question: " + QuizLogic.get_questions().get(i).toString());
                textAreaO.setText("Options: " + QuizLogic.get_options().get(i).toString());
                answerField.setText(""); // Clear the answer field for the next answer                   
            } else {
                JOptionPane.showMessageDialog(null, "You have completed the Quickfire Round!\nYour score is: " + score + "/6");
                ScoreLogger.log_score(loginGUI.getUsername(), "quickfire", score);
                quickfireFrame.dispose();
            }
        }
    });
        
    quickfirePanel.add(textAreaQ);
    quickfirePanel.add(textAreaO);
    quickfirePanel.add(startButton);
    quickfirePanel.add(answerField);

    quickfireFrame.add(quickfirePanel);
    quickfireFrame.setVisible(true);
   }
}
