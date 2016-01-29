package org.cuber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

/**
 * Created by cuber on 2016/1/21.
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class Application {

    public static void main(String[] args){
        ApplicationContext ctx = SpringApplication.run(Application.class,args);
        System.out.println("let's inspect the beans provided by spring boot");
        String[] beanNames  = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for(String beanName :beanNames){
            Object obj =  ctx.getBean(beanName);
            System.out.println(beanName + ":" + obj.getClass());
        }
    }
}
