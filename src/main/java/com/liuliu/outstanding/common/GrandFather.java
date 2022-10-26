package com.liuliu.outstanding.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GrandFather {
    @Autowired
    @Qualifier("son1")
    private Son son;
}
