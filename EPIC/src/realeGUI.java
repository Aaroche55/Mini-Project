package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class realeGUI {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        //Frame for the login page
        JFrame frame = new JFrame("Login Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 300); // Adjusted size
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

        // Heading label
        JLabel headingLabel = new JLabel("Welcome to Flinder");
        headingLabel.setFont(new Font("Gotham Rounded", Font.BOLD, 24));
        headingLabel.setForeground(Color.BLACK);
        headingLabel.setBounds(200, 10, 250, 30); // Set coordinates and size
        formPanel.add(headingLabel);

        // Additional heading label above the username field
        JLabel usernameHeadingLabel = new JLabel("  Please enter your credentials:");
        usernameHeadingLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        usernameHeadingLabel.setForeground(Color.GRAY);
        usernameHeadingLabel.setBounds(150, 50, 300, 20); // Set coordinates and size
        formPanel.add(usernameHeadingLabel);

        //ColoUrful labels and text fields for the username and password
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setForeground(Color.BLUE);
        usernameLabel.setBounds(50, 80, 100, 20); // Set coordinates and size
        JTextField usernameField = new JTextField();
        usernameField.setBounds(160, 80, 300, 20); // Set coordinates and size

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.RED);
        passwordLabel.setBounds(50, 110, 100, 20); // Set coordinates and size
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(160, 110, 300, 20); // Set coordinates and size

        //Login and Sign Up buttons
        JButton loginButton = new JButton("Login");
        loginButton.setBackground(Color.BLUE);
        loginButton.setForeground(Color.WHITE);
        loginButton.setBounds(185, 150, 100, 30); // Set coordinates and size
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // You can add login logic here
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                // Check username and password
                Authentication auth = new Authentication();
                auth.check();
                if (check(username, password)) {
                    JOptionPane.showMessageDialog(frame, "Login successful");
                } else {
                    JOptionPane.showMessageDialog(frame, "Login failed. Please check your credentials.");
                }
            }
        });

        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setBackground(Color.ORANGE);
        signUpButton.setForeground(Color.WHITE);
        signUpButton.setBounds(335, 150, 100, 30); // Set coordinates and size
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	Authentication auth = new Authentication();
                auth.signup();
                if(signup(username, password)) {
                JOptionPane.showMessageDialog(frame, "Account creation successful");
                }
                else {JOptionPane.showMessageDialog(frame, "Account creation successful");
                }
            }
        });
        
    } 
}
