package com.liuliu.outstanding.scope;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public class Write {

    @Autowired
    private Learn learn;


    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Lookup
    public Learn getLearn() {
        return learn;
    }

    public void setLearn(Learn learn) {
        this.learn = learn;
    }
}
