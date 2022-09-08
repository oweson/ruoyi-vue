package com.ruoyi.common.config.advance;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LazyCommonConfig {
    @Bean
    public DirectExchange simpleDirect(){
        return new DirectExchange("simple.direct");
    }
    @Bean
    public Queue simpleQueue(){
        return QueueBuilder.durable("simple.queue").build();
    }
}
