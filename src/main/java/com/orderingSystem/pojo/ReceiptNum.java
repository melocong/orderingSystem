package com.orderingSystem.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReceiptNum{
    //id，使用自增长或特殊算法获得。
private String id;
//初始值
private Integer startNum;
//结束值
private Integer endNum;

}
