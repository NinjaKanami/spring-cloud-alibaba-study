package com.example.nacosprovider01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class NacosProvider01Application {

    public static void main(String[] args) {
        SpringApplication.run(NacosProvider01Application.class, args);
    }

}
