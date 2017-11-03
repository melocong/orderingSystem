/*
 * Created by JFormDesigner on Wed Nov 01 21:01:03 CST 2017
 */

package com.orderingSystem.view;


import com.orderingSystem.EasyApplicationContext;
import com.orderingSystem.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.util.StringUtils;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author 123
 */
public class loginFrame extends JFrame {


    private StaffService staffService;


    public loginFrame() {
        initComponents();

    }

    private void staffBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        contentPane.remove(pwdLabel);
        contentPane.remove(pwdField);
        contentPane.repaint();
    }

    private void adminBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        pwdLabel.setText("\u5bc6      \u7801\uff1a");
        contentPane.add(pwdLabel);
        pwdLabel.setBounds(175, 285, 70, 35);
        contentPane.add(pwdField);
        pwdField.setBounds(250, 285, 130, 35);
        contentPane.repaint();
    }

    private void loginBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
        String loginName = nameText.getText().toString();
        if (StringUtils.isEmpty(loginName)){
            JOptionPane.showMessageDialog(this,"请输入用户名","提示",JOptionPane.INFORMATION_MESSAGE);
        }else {
            if (staffBtn.isSelected()){
                ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
                //获得bean
                staffService=ctx.getBean(StaffService.class);
                staffService.queryByLoginName(loginName);


            }
        }


    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        titleLabel = new JLabel();
        nameLabel = new JLabel();
        nameText = new JTextField();
        staffBtn = new JRadioButton();
        adminBtn = new JRadioButton();
        loginBtn = new JButton();
        pwdLabel = new JLabel();
        pwdField = new JPasswordField();

        //======== this ========
        setAlwaysOnTop(true);
        setResizable(false);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- titleLabel ----
        titleLabel.setText("xxxx\u70b9\u9910\u7cfb\u7edf");
        titleLabel.setFont(new Font("Abadi MT Condensed Extra Bold", Font.BOLD, 52));
        contentPane.add(titleLabel);
        titleLabel.setBounds(130, 50, 330, 65);

        //---- nameLabel ----
        nameLabel.setText("\u7528\u6237\u7f16\u53f7\uff1a");
        contentPane.add(nameLabel);
        nameLabel.setBounds(175, 170, 70, 35);
        contentPane.add(nameText);
        nameText.setBounds(250, 170, 130, 35);

        //---- staffBtn ----
        staffBtn.setText("\u5458\u5de5");
        staffBtn.setSelected(true);
        staffBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                staffBtnActionPerformed(e);
            }
        });
        contentPane.add(staffBtn);
        staffBtn.setBounds(190, 225, staffBtn.getPreferredSize().width, 45);

        //---- adminBtn ----
        adminBtn.setText("\u7ba1\u7406\u5458");
        adminBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adminBtnActionPerformed(e);
            }
        });
        contentPane.add(adminBtn);
        adminBtn.setBounds(280, 225, adminBtn.getPreferredSize().width, 45);

        //---- loginBtn ----
        loginBtn.setText("\u767b\u5f55");
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginBtnActionPerformed(e);
            }
        });
        contentPane.add(loginBtn);
        loginBtn.setBounds(215, 370, 130, 50);

        contentPane.setPreferredSize(new Dimension(580, 480));
        pack();
        setLocationRelativeTo(getOwner());

        //---- buttonGroup1 ----
        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(staffBtn);
        buttonGroup1.add(adminBtn);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel titleLabel;
    private JLabel nameLabel;
    private JTextField nameText;
    private JRadioButton staffBtn;
    private JRadioButton adminBtn;
    private JButton loginBtn;
    private JLabel pwdLabel;
    private JPasswordField pwdField;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
