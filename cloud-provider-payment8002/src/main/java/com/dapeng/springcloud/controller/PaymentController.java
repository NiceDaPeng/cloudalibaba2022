package com.dapeng.springcloud.controller;


import com.dapeng.springcloud.entities.CommonResult;
import com.dapeng.springcloud.entities.Payment;
import com.dapeng.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create( @RequestBody Payment payment ) {
        int num = paymentService.create ( payment );
        log.info( "******* 插入结果" + num );
        if ( num > 0 )
            return new CommonResult( 200,"插入数据库成功 port--->" + port,num );
        return new CommonResult( 444,"插入数据库失败port--->" + port,null );
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        System.out.println("哇哈哈！！！");
        log.info( "******* 查询结果" + payment );
        if ( payment != null )
            return new CommonResult( 200,"插入数据库成功 port--->" + port,payment );
        return new CommonResult( 444,"插入数据库失败port--->" + port,null );
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return port;
    }
}
