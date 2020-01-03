package com.hzit.controller;

import com.hzit.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    @RequestMapping("/consumer/{name}")
    public String index(@PathVariable("name") String name){
        return consumerService.consumerhystrix(name);
    }

    @RequestMapping("/test/{name}")
    public String test(@PathVariable("name") String name){
        return "测试："+name;
    }

    @RequestMapping("/demo")
    public String test(){
        return "demo测试!";
    }

}
