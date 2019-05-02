package com.cesaraap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Ventana extends JFrame{

    private ArrayList<String> stack;

    private JTextField textField1 = new JTextField();
    private JLabel result = new JLabel();

    public Ventana(){
        stack = new ArrayList<>();
        this.setTitle("Palindrome");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(4,2));

        JButton clean = new JButton("Clean");
        clean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText("");
                result.setText("");
            }
            });

            JButton button = new JButton("Check");
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    push(textField1.getText());
                    palindrome();
                    pack();
                    pop();
                }
            });

            this.add(textField1);
            this.add(result);
            this.add(clean);
            this.add(button);

            this.pack();
            this.setVisible(true);

        }

    public void push(String x) {
        stack.add(x);
    }

    public String pop(){
        return stack.remove(stack.size()-1);
    }

    public boolean find(String x) {
        return stack.contains(x);

    }

    @Override
    public String toString() {
        return stack.toString();
    }


    private void palindrome(){
            String original = textField1.getText();
            String reverse = "";

            int length = original.length();


            for (int i = length - 1; i >= 0; i--)
                reverse = reverse + original.charAt(i);

            if (original.equals(reverse))
                result.setText("The string is a palindrome.");
            else
                result.setText("The string isn't a palindrome.");
        }
}

