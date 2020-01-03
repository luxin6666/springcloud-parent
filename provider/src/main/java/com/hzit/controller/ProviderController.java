package com.hzit.controller;

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

    @RequestMapping("getAll/{name}")
    public String getAll(@PathVariable String name){
        return "这是生产者："+name+"，所使用的端口号："+port;
    }

    @RequestMapping("query")
    public String query1(){
        return "生产者被调用！！！";
    }

    @RequestMapping("query/{name}")
    public String query2(@PathVariable String name){
        return name+"生产者被调用！！！";
    }

}
