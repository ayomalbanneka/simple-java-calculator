package lk.jiat.day3.gui;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main extends JFrame implements ActionListener {

    private String firstNumber = "";
    private String secondNumber = "";
    private String operator = "";
    private boolean isNewNumber = true;

    private JTextField field;

    public Main() {

        setTitle("My Calculator");
        setSize(300, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        field = new JTextField("0");
        field.setFont(new Font("Arial", Font.BOLD, 38));
        field.setHorizontalAlignment(JTextField.RIGHT);
        field.setEditable(false);
        // field.setBorder(null);
        setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel jp = new JPanel();
        jp.setLayout(new CardLayout(5, 20));
        jp.add(field);

        add(jp, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 4, 5, 5));

        Font buttonFont = new Font("Arial", Font.PLAIN, 14);

        JButton b1 = new JButton("CE");
        JButton b2 = new JButton("C");
        JButton b3 = new JButton("DEL");
        JButton b4 = new JButton("%");
        JButton b5 = new JButton("1/x");
        JButton b6 = new JButton("x\u00B2"); // x squared
        JButton b7 = new JButton("\u221Ax"); // Square root
        JButton b8 = new JButton("/");
        JButton b9 = new JButton("7");
        JButton b10 = new JButton("8");
        JButton b11 = new JButton("9");
        JButton b12 = new JButton("x");
        JButton b13 = new JButton("4");
        JButton b14 = new JButton("5");
        JButton b15 = new JButton("6");
        JButton b16 = new JButton("-");
        JButton b17 = new JButton("1");
        JButton b18 = new JButton("2");
        JButton b19 = new JButton("3");
        JButton b20 = new JButton("+");
        JButton b21 = new JButton("\u00B1"); // Plus/Minus
        JButton b22 = new JButton("0");
        JButton b23 = new JButton(".");
        JButton b24 = new JButton("=");

        b24.setBackground(new Color(51, 51, 255));
        b24.setForeground(Color.BLACK);

        // Button Fonts
        b1.setFont(buttonFont);
        b2.setFont(buttonFont);
        b3.setFont(buttonFont);
        b4.setFont(buttonFont);
        b5.setFont(buttonFont);
        b6.setFont(buttonFont);
        b7.setFont(buttonFont);
        b8.setFont(buttonFont);
        b9.setFont(buttonFont);
        b10.setFont(buttonFont);
        b11.setFont(buttonFont);
        b12.setFont(buttonFont);
        b13.setFont(buttonFont);
        b14.setFont(buttonFont);
        b15.setFont(buttonFont);
        b16.setFont(buttonFont);
        b17.setFont(buttonFont);
        b18.setFont(buttonFont);
        b19.setFont(buttonFont);
        b20.setFont(buttonFont);
        b21.setFont(buttonFont);
        b22.setFont(buttonFont);
        b23.setFont(buttonFont);
        b24.setFont(buttonFont);

        // Buttons
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(b4);
        panel.add(b5);
        panel.add(b6);
        panel.add(b7);
        panel.add(b8);
        panel.add(b9);
        panel.add(b10);
        panel.add(b11);
        panel.add(b12);
        panel.add(b13);
        panel.add(b14);
        panel.add(b15);
        panel.add(b16);
        panel.add(b17);
        panel.add(b18);
        panel.add(b19);
        panel.add(b20);
        panel.add(b21);
        panel.add(b22);
        panel.add(b23);
        panel.add(b24);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b10.addActionListener(this);
        b11.addActionListener(this);
        b12.addActionListener(this);
        b13.addActionListener(this);
        b14.addActionListener(this);
        b15.addActionListener(this);
        b16.addActionListener(this);
        b17.addActionListener(this);
        b18.addActionListener(this);
        b19.addActionListener(this);
        b20.addActionListener(this);
        b21.addActionListener(this);
        b22.addActionListener(this);
        b23.addActionListener(this);
        b24.addActionListener(this);

        add(panel, BorderLayout.CENTER);

    }

    private void calculation() {
        double num1 = Double.parseDouble(firstNumber);
        double num2 = Double.parseDouble(field.getText());
        double result = 0;

        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "x":
                result = num1 * num2;
                break;
            case "/":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    field.setText("Error");
                    return;
                }
                break;
        }

        if (result == (long) result) {
            field.setText(String.valueOf((long) result));
        } else {
            field.setText(String.valueOf(result));
        }

        firstNumber = field.getText();
        isNewNumber = true;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String command = ((JButton) e.getSource()).getText();
        // System.out.println(command);

        if (field.getText().equals("Error") || field.getText().equals("Error...")) {
            field.setText("0");
            firstNumber = "";
            secondNumber = "";
            operator = "";
            isNewNumber = true;
        }

        Object o = e.getSource();
        if (field.getText().equals("0")) {
            field.setText("");
            isNewNumber = false;
        }

        // Handling numbers 0-9
        if (command.matches("[0-9]")) {
            if (isNewNumber) {
                field.setText("");
                isNewNumber = false;
            }
            field.setText(field.getText() + command);

        }

        // Handling decimal point

        if (command.equals(".")) {
            if (isNewNumber) {
                field.setText("0");
                isNewNumber = false;
            }
            if (!field.getText().contains(".")) {
                field.setText(field.getText() + ".");
            }
        }

        if (command.matches("[+\\-x/]")) {
            if (!operator.isEmpty() && !isNewNumber) {
                calculation();
            }

            firstNumber = field.getText();
            operator = command;
            isNewNumber = true;

        }
        if (command.equals("=")) {
            if (!operator.isEmpty()) {
                secondNumber = field.getText();
                calculation();
                operator = "";
            }
            isNewNumber = true;
        }
        if (command.equals("C")) {
            field.setText("0");
            firstNumber = "";
            secondNumber = "";
            operator = "";
            isNewNumber = true;

        }
        if (command.equals("CE")) {
            field.setText("0");
            isNewNumber = true;

        }
        if (command.equals("%")) {
            double value = Double.parseDouble(field.getText());
            field.setText(String.valueOf(value / 100));
            isNewNumber = true;

        }
        if (command.equals("1/x")) {
            double value = Double.parseDouble(field.getText());
            if (value != 0) {
                field.setText(String.valueOf(1 / value));
            } else {
                field.setText("Error...");
            }

            isNewNumber = true;

        }
        if (command.equals("x\u00B2")) {
            double value = Double.parseDouble(field.getText());
            field.setText(String.valueOf(value * value));
            isNewNumber = true;

        }
        if (command.equals("\u221Ax")) {
            double value = Double.parseDouble(field.getText());
            if (value >= 0) {
                field.setText(String.valueOf(Math.sqrt(value)));
            } else {
                field.setText("Error...");
            }
            isNewNumber = true;
        }

        if (command.equals("DEL")) {
            if (field.getText().length() > 1) {
                field.setText(field.getText().substring(0, field.getText().length() - 1));
            } else {
                field.setText("0");
                isNewNumber = true;
            }
        }

    }

    public static void main(String[] args) {

        // Themes: FlatLafLightLaf
        FlatLightLaf.setup();
        new Main().setVisible(true);
    }

}
