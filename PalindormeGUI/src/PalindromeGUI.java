import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PalindromeGUI extends JFrame implements ActionListener {

    private JTextField textField;
    private JButton checkButton;
    private JLabel resultLabel;

    public PalindromeGUI() {
        super("Palindrome Checker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new GridLayout(3, 1));

        textField = new JTextField();
        add(textField);

        checkButton = new JButton("Check");
        checkButton.addActionListener(this);
        add(checkButton);

        resultLabel = new JLabel();
        add(resultLabel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == checkButton) {
            String numberString = textField.getText();
            int number = Integer.parseInt(numberString);
            if (isPalindrome(number)) {
                resultLabel.setText(numberString + " is a palindrome.");
            } else {
                resultLabel.setText(numberString + " is not a palindrome.");
            }
        }
    }

    public boolean isPalindrome(int number) {
        int reverse = 0;
        int original = number;
        while (number != 0) {
            int digit = number % 10;
            reverse = reverse * 10 + digit;
            number /= 10;
        }
        return original == reverse;
    }

    public static void main(String[] args) {
        new PalindromeGUI();
    }
}