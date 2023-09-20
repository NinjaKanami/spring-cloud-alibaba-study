package com.example.nacosprovider01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;


@EnableDiscoveryClient
@SpringBootApplication
public class ProviderConfig01Application {

    public static void main(String[] args) {
        SpringApplication.run(ProviderConfig01Application.class, args);
    }

}
