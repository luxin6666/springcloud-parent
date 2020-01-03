package com.hzit;

import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    //随机负载均衡
    @Bean
    public RandomRule getRandomRule(){
        return new RandomRule();
    }

}
