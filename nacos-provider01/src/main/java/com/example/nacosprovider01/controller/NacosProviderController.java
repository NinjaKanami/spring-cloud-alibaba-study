package com.example.nacosprovider01.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NacosProviderController {

    @RequestMapping("/provider/{consumer}")
    public String nacosProvider(@PathVariable String consumer) {
        return "nacosProvider" + consumer;
    }
}
