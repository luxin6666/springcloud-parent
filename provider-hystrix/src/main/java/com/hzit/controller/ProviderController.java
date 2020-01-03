package com.hzit.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("provider/{name}")
    public String provider(@PathVariable String name){
        return "这是生产者："+name+"，所使用的端口号："+port;
    }

    @RequestMapping("providerhystrix/{name}")
    @HystrixCommand(fallbackMethod = "myfallback")
    public String providerhystrix(@PathVariable String name){
        if(name != null){
            throw new RuntimeException();
        }
        return "这是生产者："+name+"，所使用的端口号："+port;
    }

    public String myfallback(@PathVariable String name){
        return "所访问失败，["+name+"]资源找不到了："+port;
    }

}
