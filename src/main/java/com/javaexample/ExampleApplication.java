package com.javaexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication @ComponentScan(basePackages = { "com.javaexample","com.javaexample.box"} )
public class ExampleApplication {

    public static void main(String[] args) {

        SpringApplication.run(ExampleApplication.class, args);
    }

}
