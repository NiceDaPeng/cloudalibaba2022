package com.dapeng.myrule;

import com.netflix.loadbalancer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySelfRule {

//    单独配置负载均衡的策略，这个类不能在主启动类所在的包下及其子包下，需要在主启动类所在包的同级再建一个包来放这个配置类
    @Bean
    public IRule myRule() {
//        随机策略
        return new RandomRule(); //定义随机的负载均衡策略
//        过滤掉故障服务，然后选择并发量最小的服务
//        new BestAvailableRule();
//        轮询策略
//        new RoundRobinRule();
//        重试策略，先轮询获取服务，如果获取服务失败，则重试策略
//        new RetryRule();
//        响应速度快的实例权重越大，越容易被选择
//        new WeightedResponseTimeRule();
//        new AvailabilityFilteringRule();
//        new ZoneAvoidanceRule();
    }

}
