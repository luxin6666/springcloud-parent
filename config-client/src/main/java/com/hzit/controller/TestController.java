package com.hzit.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope // 使用该注解的类，会在接到SpringCloud配置中心配置刷新的时候，自动将新的配置更新到该类对应的字段中。
public class TestController {

    @Value("${from}")
    private String fromValue;

    @RequestMapping("/show")
    public String show(){
        return "github上的值为："+fromValue;
    }

    @Value("${server.port}")
    private String port;

    @RequestMapping("/query")
    public String query(){
        return "github上的值为："+port;
    }

}
