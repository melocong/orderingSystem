/*
 * Created by JFormDesigner on Sun Nov 05 20:46:01 CST 2017
 */

package com.orderingSystem.view;

import java.awt.*;
import javax.swing.*;

/**
 * @author 123
 */
public class ReceiptPanel extends JPanel {
    public ReceiptPanel() {
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        receiptNum = new JTextField();
        sureBtn = new JButton();

        //======== this ========
        setLayout(null);

        //---- label1 ----
        label1.setText("\u8bbe\u7f6e\u53d1\u7968\u8d77\u59cb\u503c");
        label1.setFont(new Font(".SF NS Text", Font.BOLD, 22));
        add(label1);
        label1.setBounds(10, 25, 230, 40);

        //---- label2 ----
        label2.setText("\u8d77\u59cb\u8303\u56f4\uff1a");
        add(label2);
        label2.setBounds(20, 90, label2.getPreferredSize().width, 35);
        add(receiptNum);
        receiptNum.setBounds(85, 90, 130, 35);

        //---- sureBtn ----
        sureBtn.setText("\u786e\u5b9a");
        add(sureBtn);
        sureBtn.setBounds(115, 165, 90, 40);

        setPreferredSize(new Dimension(370, 285));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JTextField receiptNum;
    private JButton sureBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
