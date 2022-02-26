package com.dapeng.springcloud.service.impl;

import com.dapeng.springcloud.dao.PaymentDao;
import com.dapeng.springcloud.entities.Payment;
import com.dapeng.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentserviceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment){
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById( id );
    }
}
