/*
 * Created by JFormDesigner on Sun Nov 05 21:20:00 CST 2017
 */

package com.orderingSystem.view.staffView;

import java.util.*;
import com.orderingSystem.pojo.Customer;
import com.orderingSystem.service.CustomerService;
import com.orderingSystem.util.ApplicationContextUtil;
import com.orderingSystem.util.Constant;
import org.springframework.util.StringUtils;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author 123
 */
public class CustomerInfoPanel extends JPanel {
    private CustomerService customerService;
    public CustomerInfoPanel() {
        customerService= ApplicationContextUtil.getApplicationContext().getBean(CustomerService.class);
        initComponents();
    }


    private void queryCustInfoButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        this.clearLabelInfo();
        String teleNo = custTeleNoTextField.getText().toString();
        if(StringUtils.isEmpty(teleNo)){
            queryResultInfoLabel.setText(Constant.CUST_INPUT_TELENO_INFO);
            return;
        }
        Customer customer=customerService.queryCustInfoByTeleNo(teleNo);
        if(customer != null){
            //给名称、地址、RTN赋值
            custNameTextField.setText(customer.getCustomerName());
            custAddressTextField.setText(customer.getCustomerAddress());
            custRtnTextField.setText(customer.getCustomerRtn());
        }else {
            //在已有客户中没有查找到，需要给出提示
            queryResultInfoLabel.setText(Constant.CUST_NOT_FOUND_AND_ADD);
        }
    }

    private void saveCustInfoButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        this.clearLabelInfo();
        String custTeleNo = custTeleNoTextField.getText().toString();
        String custName=custNameTextField.getText().toString();
        String custAddress=custAddressTextField.getText().toString();
        String custRtn=custRtnTextField.getText().toString();
        //校验对应信息的填写情况
        if(StringUtils.isEmpty(custTeleNo)){
            saveInfoLabel.setText(Constant.CUST_INPUT_TELENO_INFO);
            return;
        }
        if(StringUtils.isEmpty(custName)){
            saveInfoLabel.setText(Constant.CUST_INPUT_NAME_INFO);
            return;
        }
        if(StringUtils.isEmpty(custAddress)){
            saveInfoLabel.setText(Constant.CUST_INPUT_ADDRESS_INFO);
            return;
        }
        if(StringUtils.isEmpty(custRtn)){
            saveInfoLabel.setText(Constant.CUST_INPUT_RTN_INFO);
            return;
        }
        //执行保存的业务逻辑，先判断新增还是修改
        Customer customer=customerService.queryCustInfoByTeleNo(custTeleNo);
        if(customer==null){
            //新增
            customer=new Customer();
            customer.setCustomerName(custName);
            customer.setCustomerPhone(custTeleNo);
            customer.setCustomerAddress(custAddress);
            customer.setCustomerRtn(custRtn);
            String custId=customerService.create(customer);
            if(StringUtils.isEmpty(custId)){
                saveInfoLabel.setText(Constant.SAVE_FAILURE);
            }else {
                saveInfoLabel.setText(Constant.SAVE_SUCCESS);
            }
        }else{
            //修改
            customer.setCustomerName(custName);
            customer.setCustomerAddress(custAddress);
            customer.setCustomerRtn(custRtn);
            int updateResult=customerService.update(customer);
            if(updateResult==0){
                saveInfoLabel.setText(Constant.UPDATE_FAILURE);
            }else {
                saveInfoLabel.setText(Constant.UPDATE_SUCCESS);
            }
        }
    }

    /**
     * 清除用于信息提示的Label信息
     */
    private void clearLabelInfo(){
        queryResultInfoLabel.setText("");
        saveInfoLabel.setText("");
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("com.orderingSystem.tools.ComponentShowText");
        label1 = new JLabel();
        custTeleNoTextField = new JTextField();
        queryCustInfoButton = new JButton();
        label2 = new JLabel();
        label3 = new JLabel();
        custAddressTextField = new JTextField();
        custRtnTextField = new JTextField();
        queryResultInfoLabel = new JLabel();
        saveCustInfoButton = new JButton();
        saveInfoLabel = new JLabel();
        label4 = new JLabel();
        custNameTextField = new JTextField();

        //======== this ========
        setLayout(null);

        //---- label1 ----
        label1.setText("\u5ba2\u6237\u624b\u673a\u53f7:");
        add(label1);
        label1.setBounds(new Rectangle(new Point(45, 45), label1.getPreferredSize()));

        //---- custTeleNoTextField ----
        custTeleNoTextField.setForeground(new Color(30, 30, 30));
        add(custTeleNoTextField);
        custTeleNoTextField.setBounds(125, 35, 120, 30);

        //---- queryCustInfoButton ----
        queryCustInfoButton.setText(bundle.getString("query.text"));
        queryCustInfoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                queryCustInfoButtonActionPerformed(e);
            }
        });
        add(queryCustInfoButton);
        queryCustInfoButton.setBounds(new Rectangle(new Point(255, 35), queryCustInfoButton.getPreferredSize()));

        //---- label2 ----
        label2.setText("\u5ba2\u6237 \u5730\u5740\uff1a");
        add(label2);
        label2.setBounds(new Rectangle(new Point(45, 145), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("\u5ba2\u6237RTN\uff1a");
        add(label3);
        label3.setBounds(new Rectangle(new Point(50, 180), label3.getPreferredSize()));
        add(custAddressTextField);
        custAddressTextField.setBounds(125, 130, 120, 30);
        add(custRtnTextField);
        custRtnTextField.setBounds(125, 170, 120, 30);
        add(queryResultInfoLabel);
        queryResultInfoLabel.setBounds(new Rectangle(new Point(130, 65), queryResultInfoLabel.getPreferredSize()));

        //---- saveCustInfoButton ----
        saveCustInfoButton.setText(bundle.getString("saveCustInfoButton.text"));
        saveCustInfoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveCustInfoButtonActionPerformed(e);
            }
        });
        add(saveCustInfoButton);
        saveCustInfoButton.setBounds(new Rectangle(new Point(270, 175), saveCustInfoButton.getPreferredSize()));
        add(saveInfoLabel);
        saveInfoLabel.setBounds(new Rectangle(new Point(130, 170), saveInfoLabel.getPreferredSize()));

        //---- label4 ----
        label4.setText("\u5ba2\u6237\u540d\u79f0\uff1a");
        add(label4);
        label4.setBounds(45, 90, 65, 30);
        add(custNameTextField);
        custNameTextField.setBounds(125, 85, 120, 30);

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
    private JTextField custTeleNoTextField;
    private JButton queryCustInfoButton;
    private JLabel label2;
    private JLabel label3;
    private JTextField custAddressTextField;
    private JTextField custRtnTextField;
    private JLabel queryResultInfoLabel;
    private JButton saveCustInfoButton;
    private JLabel saveInfoLabel;
    private JLabel label4;
    private JTextField custNameTextField;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
