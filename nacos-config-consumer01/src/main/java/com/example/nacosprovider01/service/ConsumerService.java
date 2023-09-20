package com.example.nacosprovider01.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/*@FeignClient(value = "service-provider-remote-dev",path = "")*//*服务名 api前缀*/
@FeignClient(value = "service-provider-remote-dev")/*服务名 api前缀*/
public interface ConsumerService {


    /*@GetMapping(value ="/provider/{consumer}")
    String nacosProvider(@PathVariable String consumer);*/

/*    @RequestMapping("/provider/{consumer}")
    String nacosProvider(@PathVariable String consumer);*/
    @GetMapping("/hello")
    public String hello();
    @PostMapping("/testPost")
    public String hello(@RequestBody String post);
    @RequestMapping("/provider/{consumer}")
    public String nacosProvider(@PathVariable("consumer") String consumer);
}
