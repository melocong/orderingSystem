/*
 * Created by JFormDesigner on Sat Nov 04 16:30:10 CST 2017
 */

package com.orderingSystem.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author 123
 */
public class AdminFrame extends JFrame {

    private PwdPanel pwdPanel;
    private ReceiptPanel receiptPanel;



    public AdminFrame() {
        initComponents();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width,screenSize.height);
        this.setResizable(false);
        this.setVisible(true);
    }

    private void addReceiptActionPerformed(ActionEvent e) {
        // TODO add your code here
        viewPanel.removeAll();
        receiptPanel = new ReceiptPanel();
        //范围要设置好，超出就不显示了
        receiptPanel.setBounds(0, 0, 800, 800);
        viewPanel.add(receiptPanel);
        viewPanel.repaint();

    }

    private void modifyPasswordActionPerformed(ActionEvent e) {
        // TODO add your code here
        viewPanel.removeAll();
        pwdPanel = new PwdPanel();
        //范围要设置好，超出就不显示了
        pwdPanel.setBounds(0, 0, 800, 800);
        viewPanel.add(pwdPanel);
        viewPanel.repaint();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar = new JMenuBar();
        staffMenu = new JMenu();
        addStaff = new JMenuItem();
        modifyStaff = new JMenuItem();
        dishTpyeMenu = new JMenu();
        addType = new JMenuItem();
        modifyType = new JMenuItem();
        dishMenu = new JMenu();
        dishAdd = new JMenuItem();
        modifyDish = new JMenuItem();
        orderMenu = new JMenu();
        orderManage = new JMenuItem();
        otherMenu = new JMenu();
        addReceipt = new JMenuItem();
        modifyPassword = new JMenuItem();
        viewPanel = new JPanel();

        //======== this ========
        setResizable(false);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== menuBar ========
        {

            //======== staffMenu ========
            {
                staffMenu.setText("\u5458\u5de5\u7ba1\u7406");

                //---- addStaff ----
                addStaff.setText("\u6dfb\u52a0\u5458\u5de5\u4fe1\u606f");
                staffMenu.add(addStaff);

                //---- modifyStaff ----
                modifyStaff.setText("\u4fee\u6539\u5458\u5de5\u4fe1\u606f");
                staffMenu.add(modifyStaff);
            }
            menuBar.add(staffMenu);

            //======== dishTpyeMenu ========
            {
                dishTpyeMenu.setText("\u83dc\u5355\u5206\u7c7b\u7ba1\u7406");

                //---- addType ----
                addType.setText("\u589e\u52a0\u5206\u7c7b");
                dishTpyeMenu.add(addType);

                //---- modifyType ----
                modifyType.setText("\u4fee\u6539\u5206\u7c7b");
                dishTpyeMenu.add(modifyType);
            }
            menuBar.add(dishTpyeMenu);

            //======== dishMenu ========
            {
                dishMenu.setText("\u83dc\u5355\u7ba1\u7406");

                //---- dishAdd ----
                dishAdd.setText("\u6dfb\u52a0\u83dc\u5355");
                dishMenu.add(dishAdd);

                //---- modifyDish ----
                modifyDish.setText("\u4fee\u6539\u83dc\u5355");
                dishMenu.add(modifyDish);
            }
            menuBar.add(dishMenu);

            //======== orderMenu ========
            {
                orderMenu.setText("\u8ba2\u5355\u7ba1\u7406");

                //---- orderManage ----
                orderManage.setText("\u8ba2\u5355\u7ba1\u7406");
                orderMenu.add(orderManage);
            }
            menuBar.add(orderMenu);

            //======== otherMenu ========
            {
                otherMenu.setText("\u5176\u4ed6");

                //---- addReceipt ----
                addReceipt.setText("\u8bbe\u7f6e\u53d1\u7968");
                addReceipt.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        addReceiptActionPerformed(e);
                    }
                });
                otherMenu.add(addReceipt);

                //---- modifyPassword ----
                modifyPassword.setText("\u4fee\u6539\u5bc6\u7801");
                modifyPassword.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        modifyPasswordActionPerformed(e);
                    }
                });
                otherMenu.add(modifyPassword);
            }
            menuBar.add(otherMenu);
        }
        setJMenuBar(menuBar);

        //======== viewPanel ========
        {
            viewPanel.setLayout(new BorderLayout());
        }
        contentPane.add(viewPanel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JMenuBar menuBar;
    private JMenu staffMenu;
    private JMenuItem addStaff;
    private JMenuItem modifyStaff;
    private JMenu dishTpyeMenu;
    private JMenuItem addType;
    private JMenuItem modifyType;
    private JMenu dishMenu;
    private JMenuItem dishAdd;
    private JMenuItem modifyDish;
    private JMenu orderMenu;
    private JMenuItem orderManage;
    private JMenu otherMenu;
    private JMenuItem addReceipt;
    private JMenuItem modifyPassword;
    private JPanel viewPanel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
