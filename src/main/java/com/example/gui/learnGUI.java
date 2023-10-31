package com.example.gui;

import com.example.quiz.QuizLogic;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class learnGUI {
        // Declare 'i' as a class-level field to maintain its state
        @SuppressWarnings("unused")
        private static int i = 0;
    public static void main(String[] args) {
         SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }
    public static void createAndShowGUI(){
        
         // Create a JFrame for learn page
        JFrame frame = new JFrame("Learn Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500, 750);
        frame.setLayout(new BorderLayout());

        // Center the frame on the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - frame.getWidth()) / 2;
        int y = (screenSize.height - frame.getHeight()) / 2;
        frame.setLocation(x, y);

        // Create a JPanel for the learn page
        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new GridLayout(3, 3));
        optionsPanel.setBackground(Color.LIGHT_GRAY);

        // Create a label to display questions from QuizManager
        JLabel questionLabel = new JLabel();
        questionLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        questionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        optionsPanel.add(questionLabel);

        // Create a label to display options from QuizManager
        JLabel OptionsLabel = new JLabel();
        OptionsLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        OptionsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        optionsPanel.add(OptionsLabel);

        // Create a label to display questions from QuizManager
        JLabel answerLabel = new JLabel();
        answerLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        answerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        optionsPanel.add(answerLabel);

        // Create a label to display questions from QuizManager
        JTextArea textAreaQ = new JTextArea();
        textAreaQ.setBounds(-100, 10, 300, 100);
        textAreaQ.setLineWrap(true);
        textAreaQ.setWrapStyleWord(true);
        textAreaQ.setBackground(Color.LIGHT_GRAY);
        textAreaQ.setEditable(false);
        textAreaQ.setFont(new Font("Arial", Font.PLAIN, 16));

        // Create a label to display options from QuizManager
        JTextArea textAreaO = new JTextArea();
        textAreaO.setBounds(10, 10, 250, 300);
        textAreaO.setLineWrap(true);
        textAreaO.setWrapStyleWord(true);
        textAreaO.setBackground(Color.LIGHT_GRAY);
        textAreaO.setEditable(false);
        textAreaO.setFont(new Font("Arial", Font.PLAIN, 16));

        // Create a label to display answers from QuizManager
        JTextArea textAreaA = new JTextArea();
        textAreaA.setBounds(10, 10, 250, 300);
        textAreaA.setLineWrap(true);
        textAreaA.setWrapStyleWord(true);
        textAreaA.setBackground(Color.LIGHT_GRAY);
        textAreaA.setEditable(false);
        textAreaA.setFont(new Font("Arial", Font.PLAIN, 16));

        //Createw a button for next question
        JButton nextButton = new JButton("Next");
        nextButton.setBackground(Color.BLUE);
        nextButton.setForeground(Color.WHITE);
        nextButton.setFont(new Font("Arial", Font.PLAIN, 16));
        nextButton.setHorizontalAlignment(SwingConstants.CENTER);
        nextButton.setBounds(50, 110, 100, 20); // Set coordinates and size
        optionsPanel.add(nextButton);
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (i < 18) {
                        textAreaQ.setText("Question: " + QuizLogic.getAllQuestions("questions").get(i).toString());
                        textAreaO.setText("Options A,B,C: " + QuizLogic.getAllQuestions("options").get(i).toString());
                        textAreaA.setText("Answer: " + QuizLogic.getAllQuestions("answer").get(i).toString());
                        i++;
                    } else {
                        frame.dispose();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        
        optionsPanel.add(textAreaQ);
        optionsPanel.add(textAreaO);
        optionsPanel.add(textAreaA);
        optionsPanel.add(nextButton);
        
        frame.add(optionsPanel, BorderLayout.CENTER);
        frame.setVisible(true);
        
    }
}
