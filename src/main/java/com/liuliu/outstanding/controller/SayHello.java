package com.liuliu.outstanding.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SayHello {
    @GetMapping("/say")
    public String say() {
        return "Hello World !!!!";
    }

}
