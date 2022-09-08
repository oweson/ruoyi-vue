package com.ruoyi.common.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

/**
 * @author oweson
 * @date 2022/9/5 22:15
 */

@Configuration
@Slf4j
public class RabbitmqTemplateConfig {

    @Bean
    public RabbitTemplate rabbitTemplate(CachingConnectionFactory factory) {

        // 1开启消息进入Broker确认
        factory.setPublisherConfirmType(CachingConnectionFactory.ConfirmType.CORRELATED);
        // 2 开启消息未进入队列确认
        factory.setPublisherReturns(true);

        RabbitTemplate rabbitTemplate = new RabbitTemplate(factory);

        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());

        // 3 进入Broker时触发回调
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                log.info("消息进入到broker，是否到交换机:correlationData({}),ack({}),cause({})", correlationData, ack, cause);
            }
        });

        // 3 Mandatory：为true时,消息通过交换器无法匹配到队列会返回给生产者 并触发MessageReturn，为false时,匹配不到会直接被丢弃
        rabbitTemplate.setMandatory(true);
        // 4 消息未进入队列时触发回调


        rabbitTemplate.setReturnsCallback(new RabbitTemplate.ReturnsCallback() {
            @Override
            public void returnedMessage(ReturnedMessage returnedMessage) {

                Message message = returnedMessage.getMessage();

                Integer receivedDelay = message.getMessageProperties().getReceivedDelay();
                if (Objects.nonNull(receivedDelay) && receivedDelay>0) {
                    // 4 是一个延迟消息，忽略这个错误提示
                    log.info("消息未进入队列:exchange({}),route({}),replyCode({}),replyText({}),message:{}", returnedMessage.getExchange(),
                            returnedMessage.getRoutingKey(), returnedMessage.getReplyCode(), returnedMessage.getReplyText(), returnedMessage.getMessage());

                    return;
                }

                log.error("消息未进入队列:exchange({}),route({}),replyCode({}),replyText({}),message:{}", returnedMessage.getExchange(),
                        returnedMessage.getRoutingKey(), returnedMessage.getReplyCode(), returnedMessage.getReplyText(), returnedMessage.getMessage());




            }
        });

        return rabbitTemplate;
    }
}
