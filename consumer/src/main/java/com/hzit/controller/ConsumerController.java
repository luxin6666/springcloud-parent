package com.hzit.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    /*@Autowired
    private RestTemplate restTemplate;

    @RequestMapping("consumer/{name}")
    public String confumer(@PathVariable("name") String name){
        return restTemplate.getForObject("http://localhost:7901/provider/"+name, String.class);
    }*/

    @Autowired
    private EurekaClient eurekaClient;
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("consumer/{name}")
    public String confumer(@PathVariable("name") String name){
        InstanceInfo info = eurekaClient.getNextServerFromEureka("provider", false);
        String url = info.getHomePageUrl();
        System.out.println("url:"+url);
        return restTemplate.getForObject(url+"/provider/"+name, String.class);
    }

    @RequestMapping("confumerhystrix/{name}")
    public String confumerhystrix(@PathVariable("name") String name){
        InstanceInfo info = eurekaClient.getNextServerFromEureka("provider-hystrix", false);
        String url = info.getHomePageUrl();
        System.out.println("url:"+url);
        return restTemplate.getForObject(url+"/providerhystrix/"+name, String.class);
    }

}
