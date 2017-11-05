package com.orderingSystem.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

final public class ApplicationContextUtil {

    private static ApplicationContext applicationContext = null;
    private  ApplicationContextUtil(){} //空的构造方法

    static{
        /**
         * static 静态代码快,只在该类被加载时,执行一次
         */
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    }
    public static ApplicationContext getApplicationContext(){

        return applicationContext;
    }
}
