package com.orderingSystem.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Dish{
    //id，使用自增长或特殊算法获得。
private String id;
//菜的类别表编号：关联菜的类别表
private String dishTypeId;
//类别属性：0：饮料 1：其他
private Character dishType;
//菜的名称
private String dishName;
//菜的单价
private Double dishPrice;
//菜的状态：0：可售 1：售罄
private Character dishState;

}
