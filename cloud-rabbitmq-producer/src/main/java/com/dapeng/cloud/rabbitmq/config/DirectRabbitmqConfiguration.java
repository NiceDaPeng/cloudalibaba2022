package com.dapeng.cloud.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author diaopengwei
 * @date 2022/12/21
 * @apiNote
 */
@Configuration
public class DirectRabbitmqConfiguration {

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("direct_one_exchange");
    }

    @Bean
    public Queue fourQueue(){
        return new Queue("four.queue",true,false,false);
    }

    @Bean
    public Queue fiveQueue(){
        return new Queue("five.queue",true,false,false);
    }

    @Bean
    public Queue sixQueue(){
        return new Queue("six.queue",true,false,false);
    }

    @Bean
    public Binding fourBinding(){
        return BindingBuilder.bind(fourQueue()).to(directExchange()).with("four");
    }
    @Bean
    public Binding fiveBinding(){
        return BindingBuilder.bind(fiveQueue()).to(directExchange()).with("five");
    }
    @Bean
    public Binding sixBinding(){
        return BindingBuilder.bind(sixQueue()).to(directExchange()).with("six");
    }
}
