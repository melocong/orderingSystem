package com.orderingSystem.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Order{
    //id，使用自增长或特殊算法获得。
private String id;
//订单类型：1：开桌 2：外卖 3：打包
private Character orderType;
//外卖费
private Double takeOutFee;
//菜金
private Double dishExpense;
//小费：菜金10%
private Double tip;
//税：菜金15%
private Double tax;
//外卖预支费用
private Double prePay;
//外卖预支找零
private Double preChange;
//订单总金额
private Double totalFee;
//支付类型：0：现金 1：刷卡
private Character payType;
//CAI号
private String orderCai;
//发票号
private String orderReceiptNo;
//订单状态：0：未结账 1：外送 2：完结
private Character orderState;
//是否加急：0：是 1：不是
private Character isUrgent;
//客户名字
private String custName;
//客户RTN
private String custRtn;
//操作员工ID
private String staffId;
//人数
private Integer custNum;
//楼层:1：一楼 2：二楼
private Character floorType;
//桌号
private String tableNum;
//创建时间
private Long createTime;
//更新时间
private Long updateTime;
//支付时间
private Long payTime;

}
