/**
 * Copyright©2011 Xiamen Meiah Pico IT CO., Ltd. 
 * All rights reserved.
 */
package com.orderingSystem;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


public class EasyApplicationContext implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext apc) throws BeansException {
        System.out.println("apc:"+apc);
        applicationContext = apc;
    }

    public static <T> T getBean(Class<T> aClass) {
        if (applicationContext == null) {
            return null;
        }
        return applicationContext.getBean(aClass);
    }


    public static <T> T getBean(String name, Class<T> aClass) {
        if (applicationContext == null) {
            return null;
        }
        return applicationContext.getBean(name,aClass);
    }

    public static Object getBean(String name) {
        if (applicationContext == null) {
            return null;
        }
        return applicationContext.getBean(name);
    }

    public static ApplicationContext getApplicationContext() {
        if (applicationContext == null) {
            return null;
        }
        return applicationContext;
    }
}
