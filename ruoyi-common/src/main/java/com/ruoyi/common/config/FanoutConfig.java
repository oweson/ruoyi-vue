package com.ruoyi.common.config;

import com.ruoyi.common.constant.RabbitmqExchangeConstans;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutConfig {

    //设置rabbitTemplate的序列化方式，不设置默认使用jdk序列化
    //jdk序列化，对象需要继承Serializable
    //解析收到的消息为对象时，使用的是setter,所以对象需要有无参构造器
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        //使用json序列化
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        return rabbitTemplate;
    }

  /*  @Bean
    public RabbitTemplate createRabbitTemplate(ConnectionFactory connectionFactory)
    {
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory);
        //设置开启Mandatory,才能触发回调函数,⽆论消息推送结果怎么样都强制调⽤回调函数
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        return rabbitTemplate;
    }*/

    // itcast.fanout
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(RabbitmqExchangeConstans.NOTICE_FANOUT);
    }

    // fanout.queue1
    @Bean
    public Queue fanoutQueue1() {
        return new Queue("fanout.notice_queue1");
    }

    // 1 绑定队列1到交换机
    @Bean
    public Binding fanoutBinding1(Queue fanoutQueue1, FanoutExchange fanoutExchange) {
        return BindingBuilder
                .bind(fanoutQueue1)
                .to(fanoutExchange);
    }

    // fanout.queue2
    @Bean
    public Queue fanoutQueue2() {
        return new Queue("fanout.notice_queue2");
    }

    // 2 绑定队列2到交换机
    @Bean
    public Binding fanoutBinding2(Queue fanoutQueue2, FanoutExchange fanoutExchange) {
        return BindingBuilder
                .bind(fanoutQueue2)
                .to(fanoutExchange);
    }

    // fanout.queue3
    @Bean
    public Queue fanoutQueue3() {
        return new Queue("fanout.notice_queue3");
    }

    // 3 绑定队列3到交换机
    @Bean
    public Binding fanoutBinding3(Queue fanoutQueue3, FanoutExchange fanoutExchange) {
        return BindingBuilder
                .bind(fanoutQueue3)
                .to(fanoutExchange);
    }

}
