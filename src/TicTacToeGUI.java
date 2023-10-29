import javax.swing.*;
import java.awt.*;

public class TicTacToeGUI {
    private static char currentPlayer = 'X';
    private static final JButton[][] buttons = new JButton[3][3];

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tic-Tac-Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLayout(new GridLayout(3, 3));

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col] = new JButton("");
                buttons[row][col].setFont(new Font("Arial", Font.PLAIN, 40));
                buttons[row][col].setFocusPainted(false);
                final int r = row;
                final int c = col;

                buttons[row][col].addActionListener(e -> {
                    if (buttons[r][c].getText().isEmpty()) {
                        buttons[r][c].setText(String.valueOf(currentPlayer));
                        if (checkWin(r, c) || checkDraw()) {
                            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " wins!");
                            frame.dispose();
                        } else {
                            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                        }
                   }
             });

                frame.add(buttons[row][col]);
            }
        }

        frame.setVisible(true);
    }

    private static boolean checkWin(int row, int col) {
        // Check for a win in the row
        if (buttons[row][0].getText().equals(String.valueOf(currentPlayer))
                && buttons[row][1].getText().equals(String.valueOf(currentPlayer))
                && buttons[row][2].getText().equals(String.valueOf(currentPlayer))) {
            return true;
        }
        // Check for a win in the column
        if (buttons[0][col].getText().equals(String.valueOf(currentPlayer))
                && buttons[1][col].getText().equals(String.valueOf(currentPlayer))
                && buttons[2][col].getText().equals(String.valueOf(currentPlayer))) {
            return true;
        }
        // Check for a win in the diagonal (top-left to bottom-right)
        if (row == col && buttons[0][0].getText().equals(String.valueOf(currentPlayer))
                && buttons[1][1].getText().equals(String.valueOf(currentPlayer))
                && buttons[2][2].getText().equals(String.valueOf(currentPlayer))) {
            return true;
        }
        // Check for a win in the diagonal (top-right to bottom-left)
        return row + col == 2 && buttons[0][2].getText().equals(String.valueOf(currentPlayer))
                && buttons[1][1].getText().equals(String.valueOf(currentPlayer))
                && buttons[2][0].getText().equals(String.valueOf(currentPlayer));
    }

    private static boolean checkDraw() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (buttons[row][col].getText().isEmpty()) {
                    return false;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "It's a draw!");
        return true;
    }



}
