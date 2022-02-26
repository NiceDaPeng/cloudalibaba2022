package com.dapeng.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

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
}
