package com.liuliu.outstanding.controller;

import com.liuliu.outstanding.scope.Learn;
import com.liuliu.outstanding.scope.Write;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScopeLifeController {

    @Autowired
    private Write write;

    @GetMapping("getPrototypeBean")
    public void getBean() {
        Learn learn = write.getLearn();
        System.out.println(learn);
//        learn1.print();
      /*  write.print();
        write.print();*/

    }


}
