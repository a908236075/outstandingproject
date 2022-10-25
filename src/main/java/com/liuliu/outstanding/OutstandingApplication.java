package com.liuliu.outstanding;

import com.liuliu.outstanding.common.Parent;
import com.liuliu.outstanding.common.Son;
import com.liuliu.outstanding.entity.Student;
import com.liuliu.outstanding.factory.ClientService;
import com.liuliu.outstanding.factory.DefaultServiceLocator;
import com.liuliu.outstanding.mapper.BeanProcessMapper;
import com.liuliu.outstanding.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

@SpringBootApplication
public class OutstandingApplication {

    public static void main(String[] args) {

        SpringApplication.run(OutstandingApplication.class, args);
        // create and configure beans
        ApplicationContext context = new ClassPathXmlApplicationContext("Bean1.xml");
        ApplicationContext context2 = new ClassPathXmlApplicationContext();
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(BeanProcessMapper.class);
        ConfigurableListableBeanFactory beanFactory = annotationConfigApplicationContext.getBeanFactory();
        BeanProcessMapper beanProcessMapper = annotationConfigApplicationContext.getBean("beanProcessMapper", BeanProcessMapper.class);
        System.out.println(beanProcessMapper.getIsBetter());


// retrieve configured instance
        ClientService clientService = context.getBean("clientService", ClientService.class);
        ClientService clientService2 = context.getBean("clientService", ClientService.class);
        DefaultServiceLocator defaultServiceLocator = context.getBean("defaultServiceLocator", DefaultServiceLocator.class);
        ClientService clientServiceInstance = defaultServiceLocator.createClientServiceInstance();
        System.out.println(clientService == clientServiceInstance);
        System.out.println(clientService == clientService2);
        Son son = (Son) context.getBean("son");
        System.out.println(son.getAge());
        System.out.println(son.getName());
       /* Parent father = (Parent) context.getBean("father");
        System.out.println(father.getName());*/
        AnnotationConfigApplicationContext annotationConfigApplicationContext2= new AnnotationConfigApplicationContext(Son.class);
        Son son1 = annotationConfigApplicationContext2.getBean("son", Son.class);
        System.out.println(son1.getAge());
    }


}
