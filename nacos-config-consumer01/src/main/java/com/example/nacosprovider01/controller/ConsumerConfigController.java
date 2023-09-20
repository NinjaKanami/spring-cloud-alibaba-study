package com.example.nacosprovider01.controller;

import com.example.nacosprovider01.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope/*配置动态刷新 微服务配置中心更新才能更新到本地*/
@RestController
public class ConsumerConfigController {


    @Autowired
    private ConsumerService consumerService;

    @GetMapping("/consumer/{consumer}")
    public String nacosProvider(@PathVariable String consumer) {
        //return consumerService.hello("aaa");
        //return consumerService.hello();
        return consumerService.nacosProvider(consumer);
        //return "consumerService.sayHello(consumer)";
    }
}
