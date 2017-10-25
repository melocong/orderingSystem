package com.orderingSystem.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DishType{
    //id，使用自增长或特殊算法获得。
private String id;
//类别名称
private Character name;
//类别属性：0：饮料 1：其他
private Character type;

}
