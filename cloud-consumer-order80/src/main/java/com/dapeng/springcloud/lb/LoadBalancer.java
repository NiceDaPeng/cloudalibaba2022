package com.dapeng.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
* 类描述：  手写ribbon的负载均衡策略
* @Author diaopengwei
* @Date 2022/2/25 16:31
**/
public interface LoadBalancer {

    ServiceInstance instances( List< ServiceInstance> serviceInstanceList);
}
