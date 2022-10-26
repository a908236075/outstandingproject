package com.liuliu.outstanding.common;

import com.liuliu.outstanding.entity.Student;
import com.liuliu.outstanding.factory.ClientService;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Data
public class Son extends Parent {

    private String name;

    private int age;

    private Life life;

    public Son(Life life) {
        this.life = life;
    }

    public Son() {
    }

    @PostConstruct
    public void sayFather() {
        System.out.println("好爸爸!!");
    }

    @PreDestroy
    public void sayGoodbye() {
        System.out.println("再见!!");
    }


}
