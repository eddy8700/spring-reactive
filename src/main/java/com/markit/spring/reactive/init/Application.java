package com.markit.spring.reactive.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by aditya.gupta2 on 9/21/2017.
 */

@SpringBootApplication
@ComponentScan("com.markit.spring.reactive")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
