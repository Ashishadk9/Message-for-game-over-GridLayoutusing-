import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RandomNumber {
    private static int randomNumber;
    private static int attempts = 0;
    private static final int MAX_ATTEMPTS = 3;

    public static void main(String[] args) {
        // Generate random number between 1-10
        Random rand = new Random();
        randomNumber = rand.nextInt(10) + 1; // 1-10 inclusive

        JFrame frame = new JFrame("Number Guessing Game");
        frame.setLayout(new GridLayout(3, 3, 5, 5)); // 3x3 grid with 5px gaps

        // Create 9 buttons (1-9)
        for (int i = 1; i <= 9; i++) {
            JButton button = new JButton(String.valueOf(i));
            final int buttonNumber = i; // Need final for action listener

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    checkGuess(buttonNumber, frame);
                }
            });

            frame.add(button);
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    private static void checkGuess(int guessedNumber, JFrame frame) {
        if (guessedNumber == randomNumber) {
            JOptionPane.showMessageDialog(frame, "Congratulations!");
            System.exit(0);
        } else {
            attempts++;
            if (attempts >= MAX_ATTEMPTS) {
                JOptionPane.showMessageDialog(frame,
                        "Game Over!.The number was " + randomNumber);
                System.exit(0);
            } else {
                JOptionPane.showMessageDialog(frame,
                        "Wrong guess! Attempts left: " + (MAX_ATTEMPTS - attempts));
            }
        }
    }
}
