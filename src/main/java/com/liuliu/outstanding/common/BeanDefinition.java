package com.liuliu.outstanding.common;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class BeanDefinition implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().equals(Son.class)) {
            System.out.println(beanName + "初始化之前!!");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Son) {
            Son son = (Son) bean;
            System.out.println(beanName + "初始化之后!!");
            System.out.println(son.getAge());
        }
//        System.out.println(beanName+"初始化之后!!!");
        return bean;
    }
}
