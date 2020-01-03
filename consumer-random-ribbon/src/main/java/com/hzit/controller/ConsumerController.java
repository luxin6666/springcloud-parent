package com.hzit.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping("consumer/{name}")
    public String confumer(@PathVariable("name") String name){
        return restTemplate.getForObject("http://PROVIDER/provider/"+name, String.class);
    }

    @RequestMapping("index")
    public String index(){
        ServiceInstance instance = loadBalancerClient.choose("PROVIDER");
        System.out.println(instance.getServiceId()+":"+instance.getHost()+":"+instance.getPort());
        return "index";
    }

}
