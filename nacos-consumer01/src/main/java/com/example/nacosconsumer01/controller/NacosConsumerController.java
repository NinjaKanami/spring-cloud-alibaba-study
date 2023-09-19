package com.example.nacosconsumer01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class NacosConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/consumer")
    public String consumer(){
        String url = "http://localhost:8080/provider/"+"consumer";

        ServiceInstance serviceInstance = loadBalancerClient.choose("service-provider");
        String url1 = String.format("http://%s:%s/provider/%s",serviceInstance.getHost(),serviceInstance.getPort(),"consumer");
        System.out.println(restTemplate.getForObject(url1,String.class));

        return restTemplate.getForObject(url, String.class);

        /*return "consumer";*/
    }

    //获取nacos注册的服务
    @RequestMapping("/getNacosService")
    public ArrayList<Map<Object, Object>> getNacosService(){
        List<String> services = discoveryClient.getServices();
        ArrayList<Map<Object, Object>> maps = new ArrayList<>();
        System.out.println(services);
        for (String serviceName : services) {
            //根据服务Id获取实例
            List<ServiceInstance> instances = discoveryClient.getInstances(serviceName);
            for (ServiceInstance instance : instances) {
                Map<Object, Object> map = new HashMap<>();
                map.put("serviceId", instance.getServiceId());
                map.put("Uri", instance.getUri());
                map.put("Port", instance.getPort());
                map.put("Metadata", instance.getMetadata());
                map.put("InstanceId", instance.getInstanceId());
                map.put("Scheme", instance.getScheme());
                //System.out.println(instance.getMetadata());
                System.out.println(map);
                maps.add(map);
            }
        }

        return maps;
    }

}
