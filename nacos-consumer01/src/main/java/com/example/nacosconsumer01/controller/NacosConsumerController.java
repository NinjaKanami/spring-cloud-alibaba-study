package com.example.nacosconsumer01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class NacosConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping("/consumer")
    public String consumer(){
        String url = "http://localhost:8080/provider/"+"consumer";

        ServiceInstance serviceInstance = loadBalancerClient.choose("service-provider");
        String url1 = String.format("http://%s:%s/provider/%s",serviceInstance.getHost(),serviceInstance.getPort(),"consumer");
        System.out.println(restTemplate.getForObject(url1,String.class));

        return restTemplate.getForObject(url, String.class);

        /*return "consumer";*/
    }

}
