package com.project.demo;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;

public class SplashScreen extends JPanel implements ActionListener {
    private static final long serialVersionUID = 1L;
    final int PANEL_WIDTH = 800;
    final int PANEL_HEIGHT = 500;
    Image enemy, backgroundImage;
    Timer timer;
    int xVelocity = 4, yVelocity = 1;
    int x, y = 0;
    JLabel label;

    SplashScreen() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.black);
        
        enemy = loadImage("images/SplashCharacter.png");
        enemy = enemy.getScaledInstance(170, 120, Image.SCALE_DEFAULT);
        backgroundImage = loadImage("images/BackgroundSpace.jpg");
        
        timer = new Timer(10, this);
        timer.start();

        label = new JLabel("GAME ZONE");
        label.setForeground(Color.decode("#900D09"));
        label.setBounds(150, 400, 300, 100);
        Font customFont = new Font("Algerian", Font.BOLD, 70);
        label.setFont(customFont);
        this.add(label);
    }

    private Image loadImage(String path) {
        java.net.URL imgUrl = getClass().getClassLoader().getResource(path);
        if (imgUrl == null) {
            System.err.println("Error: Image not found -> " + path);
            return new ImageIcon().getImage();
        }
        return new ImageIcon(imgUrl).getImage();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(backgroundImage, 0, 0, null);
        g2D.drawImage(enemy, x, y, null);
    }

    public void actionPerformed(ActionEvent e) {
        if (x >= PANEL_WIDTH - enemy.getWidth(null) || x < 0) {
            xVelocity = -xVelocity;
        }
        x += xVelocity;
        if (y >= PANEL_HEIGHT - enemy.getHeight(null) || y < 0) {
            yVelocity = -yVelocity;
        }
        y += yVelocity;
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("GAME ZONE");
        SplashScreen panel = new SplashScreen();
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        frame.dispose();
        
        try {
            new LoginAndSignUp();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
