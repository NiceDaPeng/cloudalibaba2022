package com.dapeng.springcloud.service;

import com.dapeng.springcloud.entities.Payment;

public interface PaymentService {

    int create ( Payment payment);

    Payment getPaymentById (  Long id ) ;

}
