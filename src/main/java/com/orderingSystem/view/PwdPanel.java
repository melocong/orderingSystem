/*
 * Created by JFormDesigner on Sun Nov 05 17:14:36 CST 2017
 */

package com.orderingSystem.view;

import java.awt.*;
import javax.swing.*;

/**
 * @author 123
 */
public class PwdPanel extends JPanel {
    public PwdPanel() {
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        oldField = new JPasswordField();
        newField = new JPasswordField();
        sureField = new JPasswordField();
        sureBrn = new JButton();

        //======== this ========
        setLayout(null);

        //---- label1 ----
        label1.setText("\u65e7\u5bc6\u7801\uff1a");
        add(label1);
        label1.setBounds(55, 40, 80, 35);

        //---- label2 ----
        label2.setText("\u65b0\u5bc6\u7801\uff1a");
        add(label2);
        label2.setBounds(55, 90, 80, 35);

        //---- label3 ----
        label3.setText("\u786e\u8ba4\u5bc6\u7801\uff1a");
        add(label3);
        label3.setBounds(55, 140, 80, 35);
        add(oldField);
        oldField.setBounds(135, 40, 145, 35);
        add(newField);
        newField.setBounds(135, 90, 145, 35);
        add(sureField);
        sureField.setBounds(135, 140, 145, 35);

        //---- sureBrn ----
        sureBrn.setText("\u4fee\u6539");
        add(sureBrn);
        sureBrn.setBounds(110, 220, 140, 40);

        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < getComponentCount(); i++) {
                Rectangle bounds = getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            setMinimumSize(preferredSize);
            setPreferredSize(preferredSize);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JPasswordField oldField;
    private JPasswordField newField;
    private JPasswordField sureField;
    private JButton sureBrn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
