package com.dapeng.cloud.rabbitmq.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author diaopengwei
 * @date 2022/12/21
 * @apiNote
 */
@Service
public class FanoutService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void reciveMessage(String message){
        String exchangeName = "fanout_one_exchange";
        String routingKey = "";
        rabbitTemplate.convertAndSend(exchangeName,routingKey,message);
    }

    public void reciveDirectMessage(String message){
        String exchangeName = "direct_one_exchange";
        String routingKey = "four";
        rabbitTemplate.convertAndSend(exchangeName,routingKey,message);
    }
}
