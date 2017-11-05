package com.orderingSystem.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Customer{
    //id，使用自增长或特殊算法获得。
private String id;
//手机号码
private String customerPhone;
//名字
private String customerName;
//地址
private String customerAddress;
//RTN
private String customerRtn;
//创建时间
private Long createTime;
//更新时间
private Long updateTime;

}
