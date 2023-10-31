package com.example.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
                StatsChoice2GUI.createAndShowGUI();
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
}