package com.saitej.springbeanlifecycle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBeanlifecycleApplication {

    public static void main(String[] args) {
        System.out.println("SpringBeanlifecycleApplication.main");
        SpringApplication.run(SpringBeanlifecycleApplication.class, args);
    }

}
