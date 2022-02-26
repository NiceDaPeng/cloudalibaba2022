package com.dapeng.springcloud.service;

import com.dapeng.springcloud.entities.CommonResult;
import com.dapeng.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentService {

    @GetMapping(value = "/payment/get/{id}")
    CommonResult getPaymentById(@PathVariable("id") Long id);

    @PostMapping(value = "/payment/create")
    CommonResult create(@RequestBody Payment payment);

    //模拟feign超时控制
    @GetMapping(value = "/payment/feign/timeout")
    String paymentFeignTimeout();


}
