package com.example.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestGUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }
    public static void createAndShowGUI(){
        //Frame for the choice page
        JFrame frame = new JFrame("Test");
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
        JLabel headingLabel = new JLabel("Test");
        headingLabel.setFont(new Font("Gotham Rounded", Font.BOLD, 24));
        headingLabel.setForeground(Color.BLACK);
        headingLabel.setBounds(275, 10, 250, 30); // Set coordinates and size
        formPanel.add(headingLabel);

        // Additional heading label above the options
        JLabel subheadingLabel = new JLabel("Please select a difficulty:");
        subheadingLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        subheadingLabel.setForeground(Color.GRAY);
        subheadingLabel.setBounds(215, 50, 300, 20); // Set coordinates and size
        
        //Create 4 buttons, 
        JButton noviceButton = new JButton("Novice");
        noviceButton.setBackground(Color.RED);
        noviceButton.setForeground(Color.WHITE);
        noviceButton.setBounds(50, 125, 200, 50); // Set coordinates and size
        noviceButton.addActionListener(new ActionListener() {      //add action listener to the button
            @Override
            public void actionPerformed(ActionEvent e) {
                NoviceGUI.createAndShowGUI();
            }
        });

        JButton intermediateButton = new JButton("Intermediate");
        intermediateButton.setBackground(Color.RED);
        intermediateButton.setForeground(Color.WHITE);
        intermediateButton.setBounds(344, 125, 200, 50);// Set coordinates and size
        intermediateButton.addActionListener(new ActionListener() {     //add action listener to the button
            @Override
            public void actionPerformed(ActionEvent e) {
                IntermediateGUI.createAndShowGUI();
            }
        });

        JButton advancedButton = new JButton("Advanced");
        advancedButton.setBackground(Color.RED);
        advancedButton.setForeground(Color.WHITE);
        advancedButton.setBounds(50, 200, 200, 50);// Set coordinates and size
        advancedButton.addActionListener(new ActionListener() {      //add action listener to the button
            @Override
            public void actionPerformed(ActionEvent e) {
                QuckfireGUI.createAndShowGUI();
            }
        });

        JButton backButton = new JButton("Back");
        backButton.setBackground(Color.BLUE);
        backButton.setForeground(Color.WHITE);
        backButton.setBounds(344, 200, 200, 50); // Set coordinates and size
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                
            }
        });

        //Add headimg label to the panel
        formPanel.add(headingLabel);
        formPanel.add(subheadingLabel);
        
        //Add the buttons to the panel  
        formPanel.add(noviceButton);
        formPanel.add(intermediateButton);
        formPanel.add(advancedButton);
        formPanel.add(backButton);
        

        //Add the panel to the frame
        frame.add(formPanel);//this displays the panel on the frame

        //Make the frame visible
        frame.setVisible(true);
    }
        
}
    
