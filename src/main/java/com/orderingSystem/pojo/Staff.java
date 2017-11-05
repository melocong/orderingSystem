package com.orderingSystem.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Staff{


    //类型 '员工类型：0：系统管理员 1：跑堂 2：收银 3：外卖人员'
    public static final char STAFFF_TYPE_ADMIN= '0';
    public static final char STAFFF_TYPE_WAITER = '1';
    public static final char STAFFF_TYPE_CASHIER = '2';
    public static final char STAFFF_TYPE_DELIVER = '3';

    //id，使用自增长或特殊算法获得。
private String id;
//员工名称
private String staffName;
//员工密码，可空，管理员必填
private String password;
//登录编号
private String loginName;
//员工类型：0：系统管理员 1：跑堂 2：收银 3：外卖人员
private Character staffType;
//员工状态：0：正常 1：删除
private Character staffState;
//创建时间
private Long createTime;
//更新时间
private Long updateTime;

}
