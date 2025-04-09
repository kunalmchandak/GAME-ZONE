package com.project.demo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RockPaperScissorFrontPage extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void front() {
		JFrame frame = new JFrame();
		Font big = new Font("COMIC SANS MS", Font.BOLD, 150);
		Font small = new Font("COMIC SANS MS", Font.BOLD, 25);
		
		JLabel r = new JLabel("R");
		r.setBounds(45, 20, 150, 150);
		r.setFont(big);
		r.setForeground(Color.decode("#143d59"));
		JLabel p = new JLabel("P");
		p.setBounds(180, 20, 150, 150);
		p.setFont(big);
		p.setForeground(Color.decode("#143d59"));
		JLabel s = new JLabel("S");
		s.setBounds(300, 20, 150, 150);
		s.setFont(big);
		s.setForeground(Color.decode("#143d59"));
		JLabel ock = new JLabel("ock");
		ock.setBounds(75, 165, 50, 25);
		ock.setFont(small);
		ock.setForeground(Color.decode("#143d59"));
		JLabel aper = new JLabel("aper");
		aper.setBounds(200, 155, 100, 50);
		aper.setFont(small);
		aper.setForeground(Color.decode("#143d59"));
		JLabel cissors = new JLabel("cissors");
		cissors.setBounds(315, 165, 100, 25);
		cissors.setFont(small);
		cissors.setForeground(Color.decode("#143d59"));
		frame.add(r);
		frame.add(p);
		frame.add(s);
		frame.add(ock);
		frame.add(aper);
		frame.add(cissors);

		JButton play = new JButton("PLAY");
		play.setBounds(150, 270, 150, 50);
		play.setFont(small);
		play.setForeground(Color.decode("#e5dfe8"));
		play.setBackground(Color.decode("#143d59"));
		play.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				RockPaperScissorGamePage game= new RockPaperScissorGamePage();
				game.gameWindow();
			}
		});
		frame.add(play);

		JButton quit = new JButton("QUIT");
		quit.setBounds(150, 350, 150, 50);
		quit.setFont(small);
		quit.setForeground(Color.decode("#e5dfe8"));
		quit.setBackground(Color.decode("#143d59"));
		quit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new HomeScreen();
			}
		});
		frame.add(quit);

		frame.setSize(450,475);
		frame.setTitle("ROCK PAPER SCISSOR");
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.black);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
