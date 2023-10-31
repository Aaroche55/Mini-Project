package com.example.gui;

import javax.swing.*;
import java.awt.*;
import com.example.calculations.MeanCalculator;
import com.example.calculations.MedianCalculator;
import com.example.calculations.StandardDeviationCalculator;

public class StatsNoviceGUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    public static void createAndShowGUI() {

        // Create a JFrame for learn page
        JFrame frame = new JFrame("Stats Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 300);
        frame.setLayout(new BorderLayout());

        // Center the frame on the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - frame.getWidth()) / 2;
        int y = (screenSize.height - frame.getHeight()) / 2;
        frame.setLocation(x, y);

        //Panel for the form
        JPanel formPanel = new JPanel();
        formPanel.setLayout(null); // Set layout to null (absolute positioning)
        formPanel.setBackground(Color.LIGHT_GRAY); //set background panel

        //Heading label
        JLabel headingLabel = new JLabel("Novice");
        headingLabel.setFont(new Font("Gotham Rounded", Font.BOLD, 24));
        headingLabel.setForeground(Color.BLACK);
        headingLabel.setBounds(160, 10, 400, 30); // Set coordinates and size

        //Add Table to display stats
        JTable table = new JTable(4, 3);
        table.setBounds(100, 100, 400, 62);
        table.setValueAt(" ", 0, 0);
        table.setValueAt("User Score", 0, 1);
        table.setValueAt("Average Score", 0, 2);
        table.setValueAt("Mean", 1, 0);
        table.setValueAt(MeanCalculator.getUsersMeanByMode(loginGUI.getUsername(), "novice") + "%", 1, 1);
        table.setValueAt(MeanCalculator.getAllUsersMeanByMode("novice") + "%", 1, 2);
        table.setValueAt("Median", 2, 0);
        table.setValueAt(MedianCalculator.getUsersMedianByMode(loginGUI.getUsername(), "novice") + "%", 2, 1);
        table.setValueAt(MedianCalculator.getAllUsersMedianByMode("novice") + "%", 2, 2);
        table.setValueAt("Standard Deviation", 3, 0);
        table.setValueAt(StandardDeviationCalculator.getUsersStdDevByMode(loginGUI.getUsername(), "novice"), 3, 1);
        table.setValueAt(StandardDeviationCalculator.getAllUsersStdDevByMode("novice"), 3, 2);

        formPanel.add(headingLabel);
        formPanel.add(table);
        
        frame.add(formPanel);

        frame.setVisible(true);


    }
}
