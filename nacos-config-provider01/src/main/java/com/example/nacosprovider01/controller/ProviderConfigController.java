package com.example.nacosprovider01.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@RefreshScope/*配置动态刷新 微服务配置中心更新才能更新到本地*/
@RestController
public class ProviderConfigController {

    @Value("${server.port}")
    private String port;
    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${service.name}")
    private String serviceName;

    @RequestMapping("/provider/{consumer}")
    public String nacosProvider(@PathVariable String consumer) {
        return applicationName+"config:"+serviceName+":"+ port +"：Hello!" + consumer;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello!";
    }

    @PostMapping("/testPost")
    public String hello(@RequestBody String post) {
        return "Hello!"+post;
    }
}
