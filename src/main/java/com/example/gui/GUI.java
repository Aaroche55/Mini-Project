package com.example.gui;

import com.example.quiz.QuizLogic;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
public class GUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }
    public static void createAndShowGUI(){
        //Frame for the choice page
        JFrame frame = new JFrame("Flinder");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 300); // Adjusted size
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        // Center the frame on the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - frame.getWidth()) / 2;
        int y = (screenSize.height - frame.getHeight()) / 2;
        frame.setLocation(x, y);

        //Panel for the form
        JPanel formPanel = new JPanel();
        formPanel.setLayout(null); // Set layout to null (absolute positioning)
        formPanel.setBackground(Color.LIGHT_GRAY); //set background panel

        // Heading label
        JLabel headingLabel = new JLabel("Welcome to Flinder");
        headingLabel.setFont(new Font("Gotham Rounded", Font.BOLD, 24));
        headingLabel.setForeground(Color.BLACK);
        headingLabel.setBounds(200, 10, 250, 30); // Set coordinates and size
        formPanel.add(headingLabel);

        // Additional heading label above the options
        JLabel subheadingLabel = new JLabel("Please select an game mode");
        subheadingLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        subheadingLabel.setForeground(Color.GRAY);
        subheadingLabel.setBounds(150, 50, 300, 20); // Set coordinates and size
        
        //Create 4 buttons, 
        JButton test = new JButton("Test");
        test.setBackground(Color.RED);
        test.setForeground(Color.WHITE);
        test.setBounds(50, 125, 200, 50); // Set coordinates and size
        test.addActionListener(new ActionListener() {      //add action listener to the button
            @Override
            public void actionPerformed(ActionEvent e) {
                TestGUI.createAndShowGUI();
            }
        });

        JButton learn = new JButton("Learn");
        learn.setBackground(Color.RED);
        learn.setForeground(Color.WHITE);
        learn.setBounds(50, 200, 200, 50);// Set coordinates and size
        learn.addActionListener(new ActionListener() {     //add action listener to the button
            @Override
            public void actionPerformed(ActionEvent e) {
                learnGUI.createAndShowGUI();
            }
        });

        JButton Quickfire = new JButton("Quickfire Round");
        Quickfire.setBackground(Color.RED);
        Quickfire.setForeground(Color.WHITE);
        Quickfire.setBounds(345, 125, 200, 50);// Set coordinates and size
        Quickfire.addActionListener(new ActionListener() {      //add action listener to the button
            @Override
            public void actionPerformed(ActionEvent e) {
                QuckfireGUI.createAndShowGUI();
            }
        });

        JButton stats = new JButton("Stats");
        stats.setBackground(Color.RED);
        stats.setForeground(Color.WHITE);
        stats.setBounds(345, 200, 200, 50);// Set coordinates and size
        stats.addActionListener(new ActionListener() {      //add action listener to the button
            @Override
            public void actionPerformed(ActionEvent e) {
                createAndShowStats();
            }
        });

        //Add headimg label to the panel
        formPanel.add(headingLabel);
        
        //Add the buttons to the panel  
        formPanel.add(test);
        formPanel.add(learn);
        formPanel.add(Quickfire);
        formPanel.add(stats);

        //Add the panel to the frame
        frame.add(formPanel);//this displays the panel on the frame

        //Make the frame visible
        frame.setVisible(true);
    }
    public static void createAndShowTest(){

        for (int i = 0; i < 6; i++) {   //loop to create 6 questions
        JFrame testFrame = new JFrame("Test");
        testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        testFrame.setSize(600, 300); // Adjusted size
        testFrame.setLayout(new BorderLayout());
        testFrame.setVisible(true);

        // Center the frame on the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - testFrame.getWidth()) / 2;
        int y = (screenSize.height - testFrame.getHeight()) / 2;
        testFrame.setLocation(x, y);

        //Panel for the form
        JPanel testPanel = new JPanel();
        testPanel.setLayout(null); // Set layout to null (absolute positioning)
        testPanel.setBackground(Color.LIGHT_GRAY); //set background panel

        }

    }

    public static void createAndShowQuickfire(){

        
        JFrame quickfireFrame = new JFrame("Quickfire Round");
        quickfireFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        quickfireFrame.setSize(600, 300); // Adjusted size
        quickfireFrame.setLayout(new BorderLayout());
        quickfireFrame.setVisible(true);

        // Center the frame on the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - quickfireFrame.getWidth()) / 2;
        int y = (screenSize.height - quickfireFrame.getHeight()) / 2;
        quickfireFrame.setLocation(x, y);

        //Panel for the form
        JPanel quickfirePanel = new JPanel();
        quickfirePanel.setLayout(null); // Set layout to null (absolute positioning)
        quickfirePanel.setBackground(Color.LIGHT_GRAY); //set background panel
        
        // Heading label
        JLabel headingLabel = new JLabel("Quickfire Round");
        headingLabel.setFont(new Font("Gotham Rounded", Font.BOLD, 24));
        headingLabel.setForeground(Color.BLACK);
        headingLabel.setBounds(200, 10, 250, 30); // Set coordinates and size
        quickfirePanel.add(headingLabel);

        // Start button to fetch and display questions from QuizManager
        JButton startButton = new JButton("Start");
        startButton.setBackground(Color.BLUE);
        startButton.setForeground(Color.WHITE);
        startButton.setBounds(250, 150, 100, 30); // Set coordinates and size
        startButton.addActionListener(new ActionListener() {          
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    createAndShowQuickfire2();
                } catch (Exception ex) {
                    ex.printStackTrace();
                } finally {
                    // any cleanup code can go here
                }
            }
        });
        quickfirePanel.add(startButton);
        quickfireFrame.add(quickfirePanel, BorderLayout.CENTER);
        quickfireFrame.setVisible(true);
        
    }

    public static void createAndShowQuickfire2(){

        // Create a JFrame for the quickfire page
        JFrame frame = new JFrame("Quickfire Round");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500, 750);
        frame.setLayout(new BorderLayout());

        // Center the frame on the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - frame.getWidth()) / 2;
        int y = (screenSize.height - frame.getHeight()) / 2;
        frame.setLocation(x, y);

        // Create a JPanel for quickfire 
        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new GridLayout(3, 1));
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


        JTextField answerField = new JTextField("Please enter A, B or C");
        answerField.setBounds(160, 110, 300, 20); // Set coordinates and size
        optionsPanel.add(answerField);  

        // Button to fetch and display questions from QuizManager
        JButton getQuestionsButton = new JButton("Start/Next Question");
        getQuestionsButton.setBackground(Color.BLUE);
        getQuestionsButton.setForeground(Color.WHITE);
        getQuestionsButton.setBounds(250, 150, 10, 3); // Set coordinates and size
        getQuestionsButton.addActionListener(new ActionListener() { 
            int i = 0;         
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Call QuizManager's GetAllQuestions method and update the label
                    String questions = QuizLogic.getAllQuestions("questions").get(i).toString();
                    String options = QuizLogic.getAllQuestions("options").get(i).toString();
                    String answers = QuizLogic.getAllQuestions("answers").get(i).toString();

                    questionLabel.setText(questions);   // display the question
                    OptionsLabel.setText( options);     // display the options
                    answerField.setText(answers);       // display the answer

                    i++;    //incriment i to get the next question
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }            
            }
        });
        frame.dispose();
        optionsPanel.add(getQuestionsButton);
        frame.add(optionsPanel, BorderLayout.CENTER);
        frame.setVisible(true);



    }

    public static void createAndShowStats(){

    }
}