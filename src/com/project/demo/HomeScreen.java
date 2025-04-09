package com.project.demo;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class HomeScreen extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HomeScreen() {
        JFrame frame = new JFrame();

        JLabel E = new JLabel("GAME ZONE");
		E.setBounds(300, 2, 250, 80);
		E.setFont(new Font("Algerian", Font.BOLD, 36));
		E.setForeground(Color.WHITE);
        frame.add(E);

        Container ra = frame.getContentPane();
        JLabel si = new JLabel();
        si.setIcon(new ImageIcon(loadImage("images/RockPaperScissorIcon.png")));
        Dimension ka = si.getPreferredSize();
        si.setBounds(40, 100, ka.width, ka.height);
        ra.add(si);

        Container Ch = frame.getContentPane();
        JLabel i = new JLabel();
        i.setIcon(new ImageIcon(loadImage("images/TicTacToeIcon.png")));
        Dimension mu = i.getPreferredSize();
        i.setBounds(40, 280, mu.width, mu.height);
        Ch.add(i);

        JLabel I = new JLabel("ROCK PAPER SCISSORS");
		I.setBounds(250, 120, 250, 80);
		I.setFont(new Font("Algerian", Font.BOLD, 22));
		I.setForeground(Color.decode("#7DF9FF"));
        frame.add(I);

        JLabel S = new JLabel("TIC TAC TOE");
		S.setBounds(300, 324, 250, 80);
		S.setFont(new Font("Algerian", Font.BOLD, 22));
		S.setForeground(Color.decode("#7DF9FF"));
        frame.add(S);

        JButton KA = new JButton("CLICK TO PLAY");
        KA.setBounds(537,140,230,40);
        KA.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
        KA.setForeground(Color.decode("#F2A58E"));
        KA.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                RockPaperScissorFrontPage.front();
            }
        });
        frame.add(KA);

        JButton button = new JButton("CLICK TO PLAY");
        button.setBounds(537,344,230,40);
        button.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
        button.setForeground(Color.decode("#F2A58E"));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                new XO();
            }
        });
        frame.add(button);

        frame.setSize(800,500);
		frame.setTitle("GAME HOUSE");
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.decode("#3C3F41"));
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
    }

    private Image loadImage(String path) {
        try {
            return ImageIO.read(getClass().getClassLoader().getResourceAsStream(path));
        } catch (IOException | NullPointerException e) {
            System.err.println("Error: Image not found -> " + path);
            return null;
        }
    }

    public static void main(String[] args) {
        new HomeScreen();
    }
    
}
