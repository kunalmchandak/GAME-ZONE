package com.project.demo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class RockPaperScissorGamePage {
	
	JLabel rndm;
	JLabel win;
	JLabel loss;
	JFrame frame;
	JButton rock;
	JButton paper;
	JButton scissor;
	JButton again;
	JLabel status;
	JLabel option;
	JLabel col;
	JLabel you;
	
	public void gameWindow() {
		frame = new JFrame();
		Font small = new Font("COMIC SANS MS", Font.BOLD, 20);
		Font score = new Font("COMIC SANS MS", Font.BOLD, 50);
		Font mid = new Font("COMIC SANS MS", Font.BOLD, 12);

		JLabel back = new JLabel("<--");
		back.setBounds(20, 20, 150, 30);
		back.setForeground(Color.decode("#143d59"));
		back.setFont(new Font("COMIC SANS MS", Font.BOLD, 20));
		frame.add(back);
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});

		you = new JLabel("YOU          COMPUTER");
		you.setBounds(115, 75, 250, 50);
		you.setForeground(Color.decode("#143d59"));
		you.setFont(small);
		win = new JLabel("0");
		win.setBounds(125, 115, 150, 50);
		win.setForeground(Color.decode("#143d59"));
		win.setFont(score);
		col = new JLabel(":");
		col.setBounds(200, 115, 150, 50);
		col.setForeground(Color.decode("#143d59"));
		col.setFont(score);
		loss = new JLabel("0");
		loss.setBounds(286, 115, 150, 50);
		loss.setForeground(Color.decode("#143d59"));
		loss.setFont(score);
		frame.add(win);
		frame.add(loss);
		frame.add(col);
		frame.add(you);

		status = new JLabel();
		status.setBounds(125, 230, 250, 50);
		status.setForeground(Color.decode("#143d59"));
		status.setFont(new Font("COMIC SANS MS", Font.BOLD, 50));
		frame.add(status);

		option = new JLabel();
		option.setBounds(100, 215, 150, 30);
		option.setForeground(Color.decode("#143d59"));
		option.setFont(new Font("COMIC SANS MS", Font.BOLD, 20));
		frame.add(option);

		rndm = new JLabel();
		rndm.setBounds(266, 215, 150, 30);
		rndm.setForeground(Color.decode("#143d59"));
		rndm.setFont(new Font("COMIC SANS MS", Font.BOLD, 20));
		frame.add(rndm);

		rock = new JButton("ROCK");
		rock.setBounds(50, 300, 100, 50);
		rock.setFont(mid);
		rock.setForeground(Color.decode("#e5dfe8"));
		rock.setBackground(Color.decode("#143d59"));
		frame.add(rock);
		rock.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				option.setText("ROCK");
				check(operation(0));
			}
		});

		paper = new JButton("PAPER");
		paper.setBounds(175, 300, 100, 50);
		paper.setFont(mid);
		paper.setForeground(Color.decode("#e5dfe8"));
		paper.setBackground(Color.decode("#143d59"));
		frame.add(paper);
		paper.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				option.setText("PAPER");
				check(operation(1));
			}
		});

		scissor = new JButton("SCISSORS");
		scissor.setBounds(300, 300, 100, 50);
		scissor.setFont(mid);
		scissor.setForeground(Color.decode("#e5dfe8"));
		scissor.setBackground(Color.decode("#143d59"));
		frame.add(scissor);
		scissor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				option.setText("SCISSORS");
				check(operation(2));
			}
		});

		again = new JButton("PLAY AGAIN");
		again.setBounds(50, 375, 350, 50);
		again.setFont(small);
		again.setForeground(Color.decode("#e5dfe8"));
		again.setBackground(Color.decode("#143d59"));
		again.setVisible(false);
		frame.add(again);
		again.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				RockPaperScissorGamePage game = new RockPaperScissorGamePage();
				game.gameWindow();
			}
		});
		frame.setSize(450,475);
		frame.setTitle("ROCK PAPER SCISSOR");
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);  
		frame.setVisible(true);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private int operation(int op) {
		Random random = new Random();
		int k = random.nextInt(3);
		if(k==0)
			rndm.setText("ROCK");
		else if(k==1)
			rndm.setText("PAPER");
		else
			rndm.setText("SCISSORS");
		if(op==k)
			return 0;
		else if(k==0 && op==2)
			return -1;
		else if(k==2 && op==0)
			return 1;
		else if(k<op)
			return 1;
		else
			return -1;
	}
	
	int won = 0, lost = 0;
	private void check(int i) {
		if(i==-1)
			lost++;
		else if(i==1)
			won++;
		win.setText(String.valueOf(won));
		loss.setText(String.valueOf(lost));
		if(won == 5) {
			rndm.setVisible(false);
			option.setVisible(false);
			win.setBounds(165, 80, 150, 50);
			col.setBounds(210, 80, 150, 50);
			loss.setBounds(235, 80, 150, 50);
			status.setText("WON!!!");
			again.setVisible(true);
			rock.setVisible(false);
			paper.setVisible(false);
			scissor.setVisible(false);
			you.setVisible(false);
		}
		if(lost == 5) {
			rndm.setVisible(false);
			option.setVisible(false);
			win.setBounds(165, 80, 150, 50);
			col.setBounds(210, 80, 150, 50);
			loss.setBounds(235, 80, 150, 50);
			status.setText("LOST!!!");
			again.setVisible(true);
			rock.setVisible(false);
			paper.setVisible(false);
			scissor.setVisible(false);
			you.setVisible(false);
		}
	}
}
