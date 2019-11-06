package com.dhcc.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.dhcc.service.mapper")
@EnableDiscoveryClient
public class DhccServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DhccServiceProviderApplication.class, args);
    }

}
