package com.dapeng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayMain9527 {
    public static void main(String[] args) {
        SpringApplication.run( GatewayMain9527.class ,args );
    }
}
