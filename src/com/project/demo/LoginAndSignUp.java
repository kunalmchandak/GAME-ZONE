package com.project.demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginAndSignUp {
    private JFrame frame;
    private JTabbedPane tabbedPane;
    private JTextField loginUsernameField, signupUsernameField;
    private JPasswordField loginPasswordField, signupPasswordField;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/Your_Database_Name";
    private static final String DB_USERNAME = "Your_MySQL_Username";
    private static final String DB_PASSWORD = "Your_MySQL_Password";

    public static void main(String[] args) {
            try {
                new LoginAndSignUp();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public LoginAndSignUp() throws SQLException {
        frame = new JFrame("Login and Signup");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);

        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        JPanel loginPanel = createLoginPanel();
        JPanel signupPanel = createSignupPanel();

        tabbedPane.addTab("Login", loginPanel);
        tabbedPane.addTab("Sign Up", signupPanel);

        frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private JPanel createLoginPanel() {
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(null);
        loginPanel.setBackground(Color.BLACK);

        JLabel logtitle = new JLabel("LOGIN");
        logtitle.setBounds(330, 45, 200, 40);
        logtitle.setForeground(Color.decode("#FF7582"));
        logtitle.setFont(new Font("Calibri", Font.BOLD, 40));
        logtitle.setHorizontalAlignment(JLabel.CENTER);
        loginPanel.add(logtitle);
    
        JLabel loginLabel = new JLabel("Username");
        loginLabel.setBounds(70, 140, 200, 40);
        loginLabel.setForeground(Color.decode("#FF7582"));
        loginLabel.setFont(new Font("Calibri", Font.BOLD, 30));
        loginPanel.add(loginLabel);
    
        loginUsernameField = new JTextField(30);
        loginUsernameField.setBounds(270, 140, 400, 30);
        loginUsernameField.setFont(new Font("Calibri", Font.PLAIN, 20));
        loginUsernameField.setBackground(Color.WHITE);
        loginPanel.add(loginUsernameField);
    
        JLabel loginPasswordLabel = new JLabel("Password");
        loginPasswordLabel.setBounds(70, 220, 200, 40);
        loginPasswordLabel.setForeground(Color.decode("#FF7582"));
        loginPasswordLabel.setFont(new Font("Calibri", Font.BOLD, 30));
        loginPanel.add(loginPasswordLabel);
    
        loginPasswordField = new JPasswordField(30);
        loginPasswordField.setBounds(270, 220, 400, 30);
        loginPasswordField.setFont(new Font("Calibri", Font.PLAIN, 20));
        loginPasswordField.setBackground(Color.WHITE);
        loginPanel.add(loginPasswordField);
    
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(410, 300, 120, 40);
        loginButton.setFont(new Font("Calibri", Font.BOLD, 20));
        loginButton.setBackground(Color.decode("#FF7582"));
        loginButton.setForeground(Color.white);
        loginPanel.add(loginButton);
    
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = loginUsernameField.getText();
                char[] passwordChars = loginPasswordField.getPassword();
                String password = new String(passwordChars);
    
                if (checkLogin(username, password)) {
                    Object[] op = {"OK"};
                    int n = JOptionPane.showOptionDialog(frame, "Login successful!","Login",JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.NO_OPTION,null,op,op[0]);
                    if(n == 0){
                        frame.dispose();
                        new HomeScreen();
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Login failed. Please check your credentials.");
                }
    
                loginUsernameField.setText("");
                loginPasswordField.setText("");
            }
        });
    
        return loginPanel;
    }
    
    
    
    private JPanel createSignupPanel() {
        JPanel signupPanel = new JPanel();
        signupPanel.setLayout(null);
        signupPanel.setBackground(Color.BLACK);
    
        JLabel signupLabel = new JLabel("SIGN UP");
        signupLabel.setBounds(330, 45, 200, 40);
        signupLabel.setForeground(Color.decode("#FF7582"));
        signupLabel.setFont(new Font("Calibri", Font.BOLD, 40));
        signupLabel.setHorizontalAlignment(JLabel.CENTER);
        signupPanel.add(signupLabel);
    
        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(70, 140, 200, 40);
        usernameLabel.setForeground(Color.decode("#FF7582"));
        usernameLabel.setFont(new Font("Calibri", Font.BOLD, 30));
        signupPanel.add(usernameLabel);
    
        signupUsernameField = new JTextField(30);
        signupUsernameField.setBounds(270, 140, 400, 30);
        signupUsernameField.setFont(new Font("Calibri", Font.PLAIN, 20));
        signupUsernameField.setBackground(Color.WHITE);
        signupPanel.add(signupUsernameField);
    
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(70, 220, 400, 40);
        passwordLabel.setForeground(Color.decode("#FF7582"));
        passwordLabel.setFont(new Font("Calibri", Font.BOLD, 30));
        signupPanel.add(passwordLabel);
    
        signupPasswordField = new JPasswordField(30);
        signupPasswordField.setBounds(270, 220, 400, 30);
        signupPasswordField.setFont(new Font("Calibri", Font.PLAIN, 20));
        signupPasswordField.setBackground(Color.WHITE);
        signupPanel.add(signupPasswordField);
    
        JButton signupButton = new JButton("Sign Up");
        signupButton.setBounds(410, 300, 120, 40);
        signupButton.setFont(new Font("Calibri", Font.BOLD, 20));
        signupButton.setBackground(Color.decode("#FF7582"));
        signupButton.setForeground(Color.WHITE);
        signupPanel.add(signupButton);
    
        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = signupUsernameField.getText();
                char[] passwordChars = signupPasswordField.getPassword();
                String password = new String(passwordChars);
    
                if (isValidPassword(password) && isValidUsername(username)) {
                    if (signupUser(username, password)) {
                        JOptionPane.showMessageDialog(frame, "Signup successful!");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Signup failed. Please try a different username.");
                    }
                } else if(!isValidPassword(password)) {
                    JOptionPane.showMessageDialog(frame, "Invalid Password format. Password must be 8 characters long and contain alphabets, symbols, and numbers.");
                } else{
                    JOptionPane.showMessageDialog(frame, "Invalid Username format. Username must be 4 characters long");
                }
    
                signupUsernameField.setText("");
                signupPasswordField.setText("");
            }
        });
    
        return signupPanel;
    }
    
    private boolean isValidUsername(String username) {
        return username.length() >= 4;
    }

    private boolean isValidPassword(String password) {
        return password.length() >= 8 && password.matches(".*[a-zA-Z].*") && password.matches(".*\\d.*") && password.matches(".*[!@#$%^&*()].*");
    }
    
    

    private boolean checkLogin(String username, String password) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            String query = "SELECT * FROM user WHERE BINARY username = ? AND BINARY password = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet resultSet = stmt.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    

    private boolean signupUser(String username, String password) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            String checkQuery = "SELECT * FROM user WHERE BINARY username = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
            checkStmt.setString(1, username);
            ResultSet resultSet = checkStmt.executeQuery();
            if (resultSet.next()) {
                return false;
            }
    
            String insertQuery = "INSERT INTO user (username, password) VALUES (?, ?)";
            PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
            insertStmt.setString(1, username);
            insertStmt.setString(2, password);
            int rowsInserted = insertStmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
