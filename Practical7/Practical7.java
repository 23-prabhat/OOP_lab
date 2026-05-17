/*
Aim:
Write a Java Swing program to perform division of two numbers
and handle possible exceptions.
*/

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Practical7 extends JFrame implements ActionListener {
    private final JTextField numeratorField;
    private final JTextField denominatorField;
    private final JTextField resultField;
    private final JButton divideButton;

    public Practical7() {
        setTitle("Division Calculator");
        setSize(400, 180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));

        inputPanel.add(new JLabel("Numerator:"));
        numeratorField = new JTextField();
        inputPanel.add(numeratorField);

        inputPanel.add(new JLabel("Denominator:"));
        denominatorField = new JTextField();
        inputPanel.add(denominatorField);

        inputPanel.add(new JLabel("Result:"));
        resultField = new JTextField();
        resultField.setEditable(false);
        inputPanel.add(resultField);

        divideButton = new JButton("Divide");
        divideButton.addActionListener(this);

        add(inputPanel, BorderLayout.CENTER);
        add(divideButton, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            double numerator = Double.parseDouble(numeratorField.getText().trim());
            double denominator = Double.parseDouble(denominatorField.getText().trim());

            if (denominator == 0) {
                throw new ArithmeticException("Cannot divide by zero.");
            }

            double result = numerator / denominator;
            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values.", "Input Error",
                    JOptionPane.ERROR_MESSAGE);
            resultField.setText("");
        } catch (ArithmeticException exception) {
            JOptionPane.showMessageDialog(this, exception.getMessage(), "Arithmetic Error",
                    JOptionPane.ERROR_MESSAGE);
            resultField.setText("");
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(this, "Unexpected error: " + exception.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
            resultField.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Practical7 frame = new Practical7();
            frame.setVisible(true);
        });
    }
}

/*
Sample Usage:
1. Enter Numerator = 20
2. Enter Denominator = 4
3. Click Divide

Sample Output:
Result field displays 5.0
*/
