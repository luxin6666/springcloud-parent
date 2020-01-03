package com.hzit.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("PROVIDER")
public interface ConsumerService {

    @RequestMapping("provider/{name}")
    public String info(@PathVariable("name") String name);

}
