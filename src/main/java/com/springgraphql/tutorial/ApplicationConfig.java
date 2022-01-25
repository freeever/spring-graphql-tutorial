package com.springgraphql.tutorial;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    private static ApplicationContext applicationContext;

    public static void main(String[] args) {
        applicationContext =
                new AnnotationConfigApplicationContext(ApplicationConfig.class);

        for (String beanName : applicationContext.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }
    }
}
