package com.hzit.factory;

import com.hzit.service.ConsumerService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class MyFallBackFactory implements FallbackFactory<ConsumerService> {
    @Override
    public ConsumerService create(Throwable throwable) {
        return new ConsumerService() {
            @Override
            public String consumerhystrix(String name) {
                return "客户端"+name+"访问失败！";
            }
        };
    }
}
