package com.hzit.service;

import com.hzit.factory.MyFallBackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "PROVIDER", fallbackFactory = MyFallBackFactory.class)
public interface ConsumerService {

    @RequestMapping("/provider/{name}")
    public String consumerhystrix(@PathVariable("name") String name);

}
