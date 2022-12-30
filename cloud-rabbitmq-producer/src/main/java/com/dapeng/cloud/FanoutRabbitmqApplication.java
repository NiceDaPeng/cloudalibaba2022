package com.dapeng.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author diaopengwei
 * @date $DATE
 * @apiNote
 */
@SpringBootApplication
public class FanoutRabbitmqApplication {
    public static void main(String[] args) {
        SpringApplication.run( FanoutRabbitmqApplication.class,args);
    }
}