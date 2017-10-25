package com.orderingSystem.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderDetail{
    //id，使用自增长或特殊算法获得。
private String id;
//订单表id，关联订单表。
private String orderId;
//菜的详情表id，关联菜的详情表。
private String dishId;
//类别属性：0：饮料 1：其他
private Character dishType;
//数量
private Integer dishNum;
//点单备注
private String notes;
//是否打印：0：是 1：否
private Character isPrint;

}
