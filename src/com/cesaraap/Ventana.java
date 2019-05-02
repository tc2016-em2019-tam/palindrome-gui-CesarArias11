package com.cesaraap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Ventana extends JFrame{

    private String original;

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
                    original = textField1.getText().toLowerCase().replaceAll("\\s+","");
                    result.setText(palindrome());
                }
            });

            this.add(textField1);
            this.add(result);
            this.add(clean);
            this.add(button);

            this.pack();
            this.setVisible(true);

        }


    private String palindrome(){

        Stack stack = new Stack();

        for (int i = 0; i < original.length(); i++) {
            stack.push(original.charAt(i));
        }

        String inverted = "";

        while (!stack.isEmpty()) {
            try {
                inverted = inverted + stack.pop();
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        System.out.println(original);
        System.out.println(inverted);
        if (original.equals(inverted)) {
            return "It's a palindrome";
        } else {
            return "It's not a palindrome";
        }
    }

}

