/*
 * Created by JFormDesigner on Sat Nov 04 16:30:10 CST 2017
 */

package com.orderingSystem.view;

import java.awt.*;
import javax.swing.*;

/**
 * @author 123
 */
public class AdminFrame extends JFrame {
    public AdminFrame() {
        initComponents();
        this.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar = new JMenuBar();
        staffMenu = new JMenu();
        dishTpyeMenu = new JMenu();
        dishMenu = new JMenu();
        orderMenu = new JMenu();
        receiptMenu = new JMenu();
        pwdMenu = new JMenu();
        outMenu = new JMenu();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== menuBar ========
        {

            //======== staffMenu ========
            {
                staffMenu.setText("\u5458\u5de5\u7ba1\u7406");
            }
            menuBar.add(staffMenu);

            //======== dishTpyeMenu ========
            {
                dishTpyeMenu.setText("\u83dc\u5355\u5206\u7c7b\u7ba1\u7406");
            }
            menuBar.add(dishTpyeMenu);

            //======== dishMenu ========
            {
                dishMenu.setText("\u83dc\u5355\u7ba1\u7406");
            }
            menuBar.add(dishMenu);

            //======== orderMenu ========
            {
                orderMenu.setText("\u8ba2\u5355\u7ba1\u7406");
            }
            menuBar.add(orderMenu);

            //======== receiptMenu ========
            {
                receiptMenu.setText("\u53d1\u7968\u53f7");
            }
            menuBar.add(receiptMenu);

            //======== pwdMenu ========
            {
                pwdMenu.setText("\u4fee\u6539\u5bc6\u7801");
            }
            menuBar.add(pwdMenu);

            //======== outMenu ========
            {
                outMenu.setText("\u9000\u51fa");
            }
            menuBar.add(outMenu);
        }
        setJMenuBar(menuBar);

        contentPane.setPreferredSize(new Dimension(1195, 750));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JMenuBar menuBar;
    private JMenu staffMenu;
    private JMenu dishTpyeMenu;
    private JMenu dishMenu;
    private JMenu orderMenu;
    private JMenu receiptMenu;
    private JMenu pwdMenu;
    private JMenu outMenu;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
