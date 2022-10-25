package com.liuliu.outstanding.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SingletonChanceMore {

    @Autowired
    private Write write;


    public SingletonChanceMore(Write write) {
        this.write = write;
        printWrite();
    }

    public SingletonChanceMore() {
    }

    public void printWrite() {
        System.out.println("persist bean: " + write);
    }

    public Write getWrite() {
        return write;
    }

    public void setWrite(Write write) {
        this.write = write;
    }
}
