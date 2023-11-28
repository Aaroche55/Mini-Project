package com.example.gui;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class StartUpGUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }
    public static void createAndShowGUI(){

        JFrame frame = new JFrame("Kwizzy");
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
        JLabel headingLabel = new JLabel("Kwizzy");
        headingLabel.setFont(new Font("Goudy Stout Regular", Font.BOLD, 24));
        headingLabel.setForeground(Color.BLACK);
        headingLabel.setBounds(200, 10, 250, 30); // Set coordinates and size


        // Add Start button
        JButton start = new JButton("Start");
        start.setBackground(Color.RED);
        start.setForeground(Color.WHITE);
        start.setBounds(50, 125, 200, 50); // Set coordinates and size
        start.addActionListener(new ActionListener() {      //add action listener to the button
            @Override
            public void actionPerformed(ActionEvent e) {
                loginGUI.createAndShowGUI();
            }
        });

        formPanel.add(headingLabel);
        formPanel.add(start);
        frame.add(formPanel);


    }
}
