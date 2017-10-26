package com.orderingSystem.view;

import javax.swing.*;

public class LoginFrame {
    private JRadioButton radioButton1;
    private JPanel login;

    public static void main(String[] args) {
        JFrame frame = new JFrame("LoginFrame");
        frame.setContentPane(new LoginFrame().login);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
