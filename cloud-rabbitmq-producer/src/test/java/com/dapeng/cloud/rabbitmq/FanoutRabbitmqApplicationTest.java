package com.dapeng.cloud.rabbitmq;

import com.dapeng.cloud.rabbitmq.service.FanoutService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author diaopengwei
 * @date 2022/12/21
 * @apiNote
 */
@SpringBootTest
public class FanoutRabbitmqApplicationTest {

    @Autowired
    private FanoutService service;
    @Test
    void sendMessage(){
        service.reciveMessage("hello Rabbitmq Fanout");
    }


    @Test
    void sendDirectMessage(){
        service.reciveDirectMessage("hello Rabbitmq Direct");
    }


}
