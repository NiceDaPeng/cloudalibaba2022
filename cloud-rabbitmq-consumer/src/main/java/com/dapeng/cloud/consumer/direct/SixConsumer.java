package com.dapeng.cloud.consumer.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author diaopengwei
 * @date 2022/12/21
 * @apiNote
 */
@RabbitListener(queues = {"six.queue"})
@Component
public class SixConsumer {

    @RabbitHandler
    public void reviceMessage(String message){
        System.out.println("Six 接收到的信息为：----->"+message);
    }

}
