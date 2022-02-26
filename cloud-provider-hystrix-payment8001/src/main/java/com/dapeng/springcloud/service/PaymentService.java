package com.dapeng.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    /**
     * 方法描述:  成功的方法
     * @param: id
     * @return: String
     * @author: diaopengwei
     * @date: 2022/2/26
     */
    public String paymentInfo_OK( Integer id ) {
        return "线程池 "+Thread.currentThread().getName()+" paymentInfo_OK,id " + id+"\t" + "O(∩_∩)O哈哈";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_handler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfo_Timeout( Integer id ) {
        int timenumer = 3000;
//        int age = 10/0;
        try {
            TimeUnit.MILLISECONDS.sleep(timenumer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池 "+Thread.currentThread().getName()+" paymentInfo_OK,id " + id+"\t" + "O(∩_∩)O哈哈 耗时("+timenumer+")秒钟" ;
    }

    public String paymentInfo_handler ( Integer id ) {
        return "线程池 "+Thread.currentThread().getName()+" 运行报错，请稍后重试！ " + id+"\t" + "o(≧口≦)o" ;
    }

    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),  //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),   //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),  //时间范围  ，在时间范围内的请求次数，如果超过60%失败则跳闸
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), //失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if (id < 0){
            throw new RuntimeException("*****id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功,流水号："+serialNumber;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能负数，请稍候再试,(┬＿┬)/~~     id: " +id;
    }



}
