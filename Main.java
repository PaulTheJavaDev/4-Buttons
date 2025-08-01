package de.hup.home;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

/**
 * Handles the Main Ui Components.
 */
public class Main {

    private static int usernameClicked = 0;
    private static int passwordClicked = 0;
    private final static int framesize = 1000;

    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Home");
        mainFrame.setSize(framesize, framesize);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(null);

        createButton("Login", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Login gedrückt!");
            }
        }, buttonPanel, 575, 450, 50, 150);

        createButton("Register", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Register was Pressed, Request has been sent");
            }
        }, buttonPanel, 415, 450, 50, 150);

        JTextField usernameField = createTextField("Username", buttonPanel, 325, 235, 400,100);
        usernameField.setText("Username");

        JTextField passwordField = createTextField("Password", buttonPanel, 325, 340, 400,100);
        passwordField.setText("Password");

        mainFrame.add(buttonPanel);
        mainFrame.setVisible(true);
    }

    private static void createButton(String buttonLabel, ActionListener actionListener, JPanel panel, int XPos, int YPos, int height, int width) {
        JButton jButton = new JButton(buttonLabel);
        jButton.setBounds(XPos, YPos, width, height);
        jButton.addActionListener(actionListener);
        panel.add(jButton);
    }

    /**
     * Checks if the user is pressing for the first time, if yes then remove the text.
     */
    private static JTextField createTextField(String textFieldName, JPanel panel, int x, int y, int height, int width) {
        JTextField tf = new JTextField();
        tf.setBounds(x, y, height, width);
        tf.setFont(new Font("Arial", Font.PLAIN, 20));
        panel.add(tf);
        tf.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (Objects.equals(textFieldName, "Username") && usernameClicked == 0) {
                    tf.setText("");
                    usernameClicked++;
                } else if (Objects.equals(textFieldName, "Password") && passwordClicked == 0) {
                    tf.setText("");
                    passwordClicked++;
                }
            }
        });
        return tf;
    }

}
