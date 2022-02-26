package com.dapeng.springcloud.service.impl;

import com.dapeng.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallBackService implements PaymentHystrixService {

    @Override
    public String paymentInfo_OK(Integer id) {
        return "-----PaymentFallBackservice  Fall back  paymentInfo_ok o(≧口≦)o";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "-----PaymentFallBackservice  Fall back paymentInfo_timeout o(≧口≦)o";
    }
}
