package com.liuliu.outstanding.handbook;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoApplication implements CommandLineRunner {
    @Value("${myselfname}")
    private String name;
    @Value("${age:13}")
    private String age;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("start finish is run method");
        System.out.println("=============");
        System.out.println(name);
        System.out.println("============");
        System.out.println(age);
    }
}
