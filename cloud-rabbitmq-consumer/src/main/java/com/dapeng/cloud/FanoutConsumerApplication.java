package com.dapeng.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author diaopengwei
 * @date $DATE
 * @apiNote
 */
@SpringBootApplication
public class FanoutConsumerApplication {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        SpringApplication.run( FanoutConsumerApplication.class,args);
    }
}