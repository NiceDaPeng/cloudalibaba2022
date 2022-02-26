package com.dapeng.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
* 类描述：
* @Author diaopengwei
* @Date 2022/2/25 16:33
**/
@Component
public class MyLB implements LoadBalancer{

    //
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {
        int current ;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0:current + 1;

        } while ( !this.atomicInteger.compareAndSet(current,next) );
        System.out.println("**** next --" + next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstanceList) {
        int index = getAndIncrement() % serviceInstanceList.size();
        return serviceInstanceList.get(index);
    }

}
