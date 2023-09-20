package com.example.nacosprovider01.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
