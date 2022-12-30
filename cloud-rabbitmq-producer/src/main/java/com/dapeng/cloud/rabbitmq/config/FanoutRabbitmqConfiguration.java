package com.dapeng.cloud.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author diaopengwei
 * @date 2022/12/21
 * @apiNote
 */
@Configuration
public class FanoutRabbitmqConfiguration {

    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanout_one_exchange");
    }

    @Bean
    public Queue oneQueue(){
        return new Queue("one.queue",true,false,false);
    }

    @Bean
    public Queue twoQueue(){
        return new Queue("two.queue",true,false,false);
    }

    @Bean
    public Queue threeQueue(){
        return new Queue("three.queue",true,false,false);
    }

    @Bean
    public Binding oneBinding(){
        return BindingBuilder.bind(oneQueue()).to(fanoutExchange());
    }
    @Bean
    public Binding twoBinding(){
        return BindingBuilder.bind(twoQueue()).to(fanoutExchange());
    }
    @Bean
    public Binding threeBinding(){
        return BindingBuilder.bind(threeQueue()).to(fanoutExchange());
    }
}
