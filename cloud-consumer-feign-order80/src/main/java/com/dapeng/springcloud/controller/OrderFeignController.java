package com.dapeng.springcloud.controller;


import com.dapeng.springcloud.entities.CommonResult;
import com.dapeng.springcloud.entities.Payment;
import com.dapeng.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderFeignController {

    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id ) {

        CommonResult result = paymentService.getPaymentById(id);
        return result;
    }

    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeout(){
        //openfeign 底层封装了ribbon  消费者一般默认等待1秒，
        return paymentService.paymentFeignTimeout();
    }
}
