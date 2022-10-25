package com.liuliu.outstanding;

import com.liuliu.outstanding.scope.SingletonChanceMore;
import com.liuliu.outstanding.scope.Write;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
public class LifeTest {
    @Test
    public void getBeanLife() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Write.class);
        Write bean1 = applicationContext.getBean("write", Write.class);
        bean1.setName("张三");
        System.out.println(bean1.getName());
        SingletonChanceMore singletonChanceMore = new SingletonChanceMore();
        singletonChanceMore.printWrite();
    }


}
