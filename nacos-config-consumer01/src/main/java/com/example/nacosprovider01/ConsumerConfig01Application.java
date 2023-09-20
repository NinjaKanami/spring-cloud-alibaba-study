package com.example.nacosprovider01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class ConsumerConfig01Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerConfig01Application.class, args);
    }

}
