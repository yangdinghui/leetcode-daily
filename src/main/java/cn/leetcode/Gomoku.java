package cn.leetcode;// Implement Gomoku with a user interface in Java
// Implement Gomoku with a user interface in Java

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Gomoku {
    private static final int BOARD_SIZE = 15;
    private static final int WINNING_LENGTH = 5;
    private int[][] board;
    private int currentPlayer;

    public Gomoku() {
        board = new int[BOARD_SIZE][BOARD_SIZE];
        currentPlayer = 1;
        createAndShowGUI();
    }

    public boolean placeStone(int x, int y) {
        if (board[x][y] == 0) {
            board[x][y] = currentPlayer;
            return true;
        }
        return false;
    }

    public boolean checkWin(int x, int y) {
        // Check horizontal, vertical, and diagonal lines for a win
        return checkLine(x, y, 1, 0) || checkLine(x, y, 0, 1) || checkLine(x, y, 1, 1) || checkLine(x, y, 1, -1);
    }

    private boolean checkLine(int x, int y, int dx, int dy) {
        int count = 1;
        for (int i = 1; i < WINNING_LENGTH; i++) {
            if (isValidCoordinate(x + i * dx, y + i * dy) && board[x + i * dx][y + i * dy] == currentPlayer) {
                count++;
            } else {
                break;
            }
        }
        for (int i = 1; i < WINNING_LENGTH; i++) {
            if (isValidCoordinate(x - i * dx, y - i * dy) && board[x - i * dx][y - i * dy] == currentPlayer) {
                count++;
            } else {
                break;
            }
        }
        return count >= WINNING_LENGTH;
    }

    private boolean isValidCoordinate(int x, int y) {
        return x >= 0 && x < BOARD_SIZE && y >= 0 && y < BOARD_SIZE;
    }

    public void switchPlayer() {
        currentPlayer = 3 - currentPlayer;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Gomoku");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);

        JPanel boardPanel = new JPanel(new GridLayout(BOARD_SIZE, BOARD_SIZE));
        JButton[][] buttons = new JButton[BOARD_SIZE][BOARD_SIZE];

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setPreferredSize(new Dimension(30, 30));
                buttons[i][j].setOpaque(true);
                buttons[i][j].setBackground(Color.WHITE);
                int finalI = i;
                int finalJ = j;
                buttons[i][j].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (placeStone(finalI, finalJ)) {
                            buttons[finalI][finalJ].setBackground(currentPlayer == 1 ? Color.BLACK : Color.WHITE);
                            buttons[finalI][finalJ].setEnabled(false);
                            if (checkWin(finalI, finalJ)) {
                                JOptionPane.showMessageDialog(frame, "Player " + currentPlayer + " wins!");
                                frame.dispose();
                            } else {
                                switchPlayer();
                            }
                        }
                    }
                });
                boardPanel.add(buttons[i][j]);
            }
        }

        frame.add(boardPanel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Gomoku();
            }
        });
    }
}