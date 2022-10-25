package com.liuliu.outstanding.common;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Data
@Component
public class Son extends Parent {

    private String name;

    private int age;

    @PostConstruct
    public void sayFather() {
        System.out.println("好爸爸!!");
    }
    @PreDestroy
    public void  sayGoodbye(){
        System.out.println("再见!!");
    }
    
}
