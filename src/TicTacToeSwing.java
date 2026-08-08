import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToeSwing {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Tic Tac Toe");

        frame.setSize(450, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String player1 = JOptionPane.showInputDialog(frame, "Enter Player 1 name:");
        String player2 = JOptionPane.showInputDialog(frame, "Enter Player 2 name:");

        JLabel turnLabel = new JLabel(player1 + "'s turn (X)", SwingConstants.CENTER);

        JLabel scoreLabel = new JLabel(  player1 + " (X): 0     " + player2 + " (O): 0",
    SwingConstants.CENTER
);

turnLabel.setFont(new Font("Arial", Font.BOLD, 20));

scoreLabel.setFont(new Font("Arial", Font.BOLD, 16));
JLabel titleLabel = new JLabel("TIC TAC TOE", SwingConstants.CENTER);
titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
       

       JPanel panel = new JPanel();
panel.setLayout(new GridLayout(3, 3, 5, 5));
panel.setBackground(Color.BLACK);
        JButton[] buttons = new JButton[9];
boolean[] gameOver = {false};
 boolean[] xTurn = {true};
 
        int[] player1Score = {0};
        int[] player2Score = {0};
       JButton restartButton = new JButton("Restart");
restartButton.setFont(new Font("Arial", Font.BOLD, 18));
restartButton.setFocusPainted(false);

JButton resetScoreButton = new JButton("Reset Score");
resetScoreButton.setFont(new Font("Arial", Font.BOLD, 18));
resetScoreButton.setFocusPainted(false);

        restartButton.addActionListener(new ActionListener() {

    public void actionPerformed(ActionEvent e) {

       for (int i = 0; i < buttons.length; i++) {
    buttons[i].setText("");
    buttons[i].setForeground(Color.BLACK);
    buttons[i].setBackground(Color.WHITE);
}

        xTurn[0] = true;
        gameOver[0] = false;

        turnLabel.setText(player1 + "'s turn (X)");
    }
});

resetScoreButton.addActionListener(new ActionListener() {

    public void actionPerformed(ActionEvent e) {

        player1Score[0] = 0;
        player2Score[0] = 0;

        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setText("");
            buttons[i].setForeground(Color.BLACK);
            buttons[i].setBackground(Color.WHITE);
        }

        xTurn[0] = true;
        gameOver[0] = false;

        scoreLabel.setText(
            player1 + " (X): 0     " +
            player2 + " (O): 0"
        );

        turnLabel.setText(player1 + "'s turn (X)");
    }
});

JPanel mainPanel = new JPanel(new BorderLayout());

JPanel topPanel = new JPanel(new GridLayout(3, 1));
topPanel.add(titleLabel);

topPanel.add(scoreLabel);
topPanel.add(turnLabel);

       


for (int i = 0; i < 9; i++) {

           buttons[i] = new JButton("");
JButton button = buttons[i];
               button.setFont(new Font("Arial", Font.BOLD, 50));
   button.setForeground(Color.BLACK);
    button.setBackground(Color.WHITE);
    button.setFocusPainted(false);


            button.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {

                   if (button.getText().equals("") && !gameOver[0]) {

  if (xTurn[0]) {
    button.setText("X");
    button.setForeground(Color.BLUE);
    xTurn[0] = false;
} else {
    button.setText("O");
    button.setForeground(Color.RED);
    xTurn[0] = true;
}

if (xTurn[0]) {
    turnLabel.setText(player1 + "'s turn (X)");
} else {
    turnLabel.setText(player2 + "'s turn (O)");
}
                       if (checkWinner(buttons)) {

    gameOver[0] = true;

    String winner;

    

if (xTurn[0]) {
    winner = player2;
} else {
    winner = player1;
}

if (xTurn[0]) {
    player2Score[0]++;
} else {
    player1Score[0]++;
}

scoreLabel.setText(
    player1 + " (X): " + player1Score[0] +
    "     " +
    player2 + " (O): " + player2Score[0]
);

int choice = JOptionPane.showConfirmDialog(
        frame,
        winner + " Wins!\n\nPlay another round?",
        "Game Over",
        JOptionPane.YES_NO_OPTION
);

if (choice == JOptionPane.YES_OPTION) {

    for (int i = 0; i < buttons.length; i++) {
        buttons[i].setText("");
        buttons[i].setForeground(Color.BLACK);
        buttons[i].setBackground(Color.WHITE);
    }

    xTurn[0] = true;
    gameOver[0] = false;

    turnLabel.setText(player1 + "'s turn (X)");

} else {

    frame.dispose();
}

} else if (checkDraw(buttons)) {

    gameOver[0] = true;

    int choice = JOptionPane.showConfirmDialog(
            frame,
            "It's a Draw!\n\nPlay another round?",
            "Game Over",
            JOptionPane.YES_NO_OPTION
    );

    if (choice == JOptionPane.YES_OPTION) {

        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setText("");
            buttons[i].setForeground(Color.BLACK);
            buttons[i].setBackground(Color.WHITE);
        }

        xTurn[0] = true;
        gameOver[0] = false;

        turnLabel.setText(player1 + "'s turn (X)");

    } else {

        frame.dispose();
    }
}
                    }
                }
            }
        );

            panel.add(button);
        }

      

mainPanel.add(topPanel, BorderLayout.NORTH);
mainPanel.add(panel, BorderLayout.CENTER);
JPanel bottomPanel = new JPanel();

bottomPanel.add(restartButton);
bottomPanel.add(resetScoreButton);

mainPanel.add(bottomPanel, BorderLayout.SOUTH);
frame.add(mainPanel);
frame.setVisible(true);
    }
    static boolean checkWinner(JButton[] buttons) {

    int[][] winningCombinations = {
        {0, 1, 2},
        {3, 4, 5},
        {6, 7, 8},
        {0, 3, 6},
        {1, 4, 7},
        {2, 5, 8},
        {0, 4, 8},
        {2, 4, 6}
    };

    for (int[] combination : winningCombinations) {

    int a = combination[0];
    int b = combination[1];
    int c = combination[2];

    if (!buttons[a].getText().equals("") &&
        buttons[a].getText().equals(buttons[b].getText()) &&
        buttons[b].getText().equals(buttons[c].getText())) {

        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        return true;
    }
}

    return false;
}
static boolean checkDraw(JButton[] buttons) {

    for (int i = 0; i < buttons.length; i++) {

        if (buttons[i].getText().equals("")) {
            return false;
        }
    }

    return true;
}
}