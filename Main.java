package de.hup.home;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    private final static Dimension dimension = new Dimension(200,200);
    private final static int framesize = 1000;

    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Home");
        mainFrame.setSize(framesize, framesize);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 300));
        buttonPanel.setOpaque(false);
        createButtons(new String[]{"Guest Login", "Student Login", "Teacher Login", "Admin Login"}, buttonPanel);

        mainFrame.add(buttonPanel);
        mainFrame.setVisible(true);
    }

    private static JButton createButton(String buttonLabel, ActionListener actionListener) {
        JButton jButton = new JButton(buttonLabel);
        jButton.setPreferredSize(dimension);
        jButton.addActionListener(actionListener);
        return jButton;
    }

    private static void createButtons(String[] buttonlabels, JPanel buttonPanel) {
        for (String buttonlabel: buttonlabels){
            buttonPanel.add(createButton(buttonlabel, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println(buttonlabel + " has been pressed");
                }
            }));
        }
    }
}
