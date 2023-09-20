package com.example.nacosprovider01.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NacosProviderController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/provider/{consumer}")
    public String nacosProvider(@PathVariable String consumer) {
        return "TEstnacosProvider:"+ port +"：Hello!" + consumer;
    }
}
