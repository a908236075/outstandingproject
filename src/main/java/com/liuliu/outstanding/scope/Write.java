package com.liuliu.outstanding.scope;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class Write implements ApplicationContextAware {

//    @Autowired
    private Learn learn;

    private ApplicationContext applicationContext;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //    @Lookup
    // 每次调用都获取一个新的
    public Learn getLearn() {
        return applicationContext.getBean("learn", Learn.class);
    }

    public void setLearn(Learn learn) {
        this.learn = learn;
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
