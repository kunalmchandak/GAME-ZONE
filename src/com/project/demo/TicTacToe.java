package com.project.demo;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

class XO implements ActionListener {
    JFrame frame = new JFrame();
    JPanel t_panel = new JPanel();
    JPanel bt_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] bton = new JButton[9];
    int chance_flag = 0;
    Random random = new Random();
    boolean pl1_chance;

    XO() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(bt_panel);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setTitle("TIC  TAC  TOE");
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textfield.setBackground(new Color(0, 0, 0));
        textfield.setForeground(Color.decode("#c31736"));
        textfield.setFont(new Font("Comics Sans MS", Font.PLAIN, 60));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("TIC  TAC  TOE");
        textfield.setOpaque(true);

        t_panel.setLayout(new BorderLayout());
        t_panel.setBounds(0, 0, 800, 500);

        bt_panel.setLayout(new GridLayout(3, 3));
        bt_panel.setBackground(new Color(0, 0, 0));

        for (int i = 0; i < 9; i++) {
            bton[i] = new JButton();
            bt_panel.add(bton[i]);
            bton[i].setFont(new Font("Comics Sans MS", Font.PLAIN, 120));
            bton[i].setFocusable(false);
            bton[i].addActionListener(this);
            bton[i].setBackground(Color.black);
        }

        t_panel.add(textfield);
        frame.add(t_panel, BorderLayout.NORTH);
        frame.add(bt_panel);
        startGame();
    }


    public void startGame() {
        try {
            textfield.setText("LOADING....");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int chance = random.nextInt(100);

        if (chance % 2 == 0) {
            pl1_chance = true;
            textfield.setForeground(Color.decode("#00BFFF"));
            textfield.setText("X TURN");
        } else {
            pl1_chance = false;
            textfield.setForeground(Color.decode("#612655"));
            textfield.setText("O TURN");
        }
    }

    public void gameOver(String s) {
        chance_flag = 0;
        Object[] option = { "RESTART", "EXIT" };
        int n = JOptionPane.showOptionDialog(frame, "GAME OVER !!\n" + s, "GAME OVER", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.NO_OPTION, null, option, option[0]);
        if (n == 0) {
            frame.dispose();
            new XO();
        } else {
            frame.dispose();
            new HomeScreen();
        }
    }

    public void matchCheck() {
        if ((bton[0].getText() == "X") && (bton[1].getText() == "X") && (bton[2].getText() == "X")) {
            xWins(0, 1, 2);
        } else if ((bton[0].getText() == "X") && (bton[4].getText() == "X") && (bton[8].getText() == "X")) {
            xWins(0, 4, 8);
        } else if ((bton[0].getText() == "X") && (bton[3].getText() == "X") && (bton[6].getText() == "X")) {
            xWins(0, 3, 6);
        } else if ((bton[1].getText() == "X") && (bton[4].getText() == "X") && (bton[7].getText() == "X")) {
            xWins(1, 4, 7);
        } else if ((bton[2].getText() == "X") && (bton[4].getText() == "X") && (bton[6].getText() == "X")) {
            xWins(2, 4, 6);
        } else if ((bton[2].getText() == "X") && (bton[5].getText() == "X") && (bton[8].getText() == "X")) {
            xWins(2, 5, 8);
        } else if ((bton[3].getText() == "X") && (bton[4].getText() == "X") && (bton[5].getText() == "X")) {
            xWins(3, 4, 5);
        } else if ((bton[6].getText() == "X") && (bton[7].getText() == "X") && (bton[8].getText() == "X")) {
            xWins(6, 7, 8);
        }

        else if ((bton[0].getText() == "O") && (bton[1].getText() == "O") && (bton[2].getText() == "O")) {
            oWins(0, 1, 2);
        } else if ((bton[0].getText() == "O") && (bton[3].getText() == "O") && (bton[6].getText() == "O")) {
            oWins(0, 3, 6);
        } else if ((bton[0].getText() == "O") && (bton[4].getText() == "O") && (bton[8].getText() == "O")) {
            oWins(0, 4, 8);
        } else if ((bton[1].getText() == "O") && (bton[4].getText() == "O") && (bton[7].getText() == "O")) {
            oWins(1, 4, 7);
        } else if ((bton[2].getText() == "O") && (bton[4].getText() == "O") && (bton[6].getText() == "O")) {
            oWins(2, 4, 6);
        } else if ((bton[2].getText() == "O") && (bton[5].getText() == "O") && (bton[8].getText() == "O")) {
            oWins(2, 5, 8);
        } else if ((bton[3].getText() == "O") && (bton[4].getText() == "O") && (bton[5].getText() == "O")) {
            oWins(3, 4, 5);
        } else if ((bton[6].getText() == "O") && (bton[7].getText() == "O") && (bton[8].getText() == "O")) {
            oWins(6, 7, 8);
        } else if (chance_flag == 9) {
            textfield.setForeground(Color.decode("#c31736"));
            textfield.setText("GAME DRAW !!");
            gameOver("GAME DRAW !!");
        }
    }

    public void xWins(int x1, int x2, int x3) {
        bton[x1].setBackground(Color.GREEN);
        bton[x2].setBackground(Color.GREEN);
        bton[x3].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            bton[i].setEnabled(false);
        }
        textfield.setForeground(Color.decode("#00BFFF"));
        textfield.setText("X WINS");
        gameOver("'X' WINS");

    }


    public void oWins(int x1, int x2, int x3) {
        bton[x1].setBackground(Color.GREEN);
        bton[x2].setBackground(Color.GREEN);
        bton[x3].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            bton[i].setEnabled(false);
        }
        textfield.setForeground(Color.decode("#612655"));
        textfield.setText("O WINS");
        gameOver("'O' WINS");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == bton[i]) {
                if (pl1_chance) {
                    if (bton[i].getText() == "") {
                        bton[i].setForeground(Color.decode("#00BFFF"));
                        bton[i].setText("X");
                        pl1_chance = false;
                        textfield.setText("O TURN");
                        textfield.setForeground(Color.decode("#612655"));
                        chance_flag++;
                        matchCheck();
                    }
                } else {
                    if (bton[i].getText() == "") {
                        bton[i].setForeground(Color.decode("#612655"));
                        bton[i].setText("O");
                        pl1_chance = true;
                        textfield.setForeground(Color.decode("#00BFFF"));
                        textfield.setText("X TURN");
                        chance_flag++;
                        matchCheck();
                    }
                }
            }
        }
    }
}

public class TicTacToe {
    public static void main(String[] args) throws Exception {
        new XO();
    }
}
