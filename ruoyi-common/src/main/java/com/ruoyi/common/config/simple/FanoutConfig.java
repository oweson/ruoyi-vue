package com.ruoyi.common.config.simple;

import com.ruoyi.common.constant.RabbitmqExchangeConstans;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutConfig {

    //设置rabbitTemplate的序列化方式，不设置默认使用jdk序列化
    //jdk序列化，对象需要继承Serializable
    //解析收到的消息为对象时，使用的是setter,所以对象需要有无参构造器
   /* @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        //使用json序列化
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        return rabbitTemplate;
    }*/

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
        // 持久化，是否自动删除
        return new FanoutExchange(RabbitmqExchangeConstans.NOTICE_FANOUT,true,false);
    }

    // fanout.queue1
    @Bean
    public Queue fanoutQueue1() {
        // 其三个参数：durable exclusive autoDelete
        // 一般只设置一下持久化即可
        // 创建Exchange和队列时只要设置好持久化，发送的消息默认就是持久化消息。
        //设置持久化时一定要将Exchange和队列都设置上持久化：
        //单单只设置Exchange持久化，重启之后队列会丢失。单单只设置队列的持久化，重启之后Exchange会消失，既而消息也丢失，所以如果不两个一块设置持久化将毫无意义。
        return new Queue("fanout.notice_queue1",true,false,false);
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
