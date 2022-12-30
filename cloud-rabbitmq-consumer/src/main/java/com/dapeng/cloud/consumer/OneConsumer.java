package com.dapeng.cloud.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author diaopengwei
 * @date 2022/12/21
 * @apiNote
 */
@RabbitListener(queues = {"one.queue"})
@Component
public class OneConsumer {

    @RabbitHandler
    public void reviceMessage(String message){
        System.out.println("one接收到的信息为：----->"+message);
    }

}
