package com.liuliu.outstanding.config;

import com.liuliu.outstanding.common.Son;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class LifeConfig {

    /*@Bean("singletonChanceMore")
    public SingletonChanceMore singletonChanceMore(){
        return new SingletonChanceMore();
    }*/

    /*@Bean("write")
    public Write write(){
        return new Write();
    }*/

    @Bean
    @Qualifier("son1")
    @Primary
    public Son getSon1() {
        Son son = new Son();
        son.setName("张三");
        return son;
    }

    @Bean
    public Son getSon2() {
        Son son = new Son();
        son.setName("李四");
        return son;
    }


}
