package com.ruoyi.system.listener;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.rabbitmq.client.Channel;
import com.ruoyi.system.domain.SysMq;
import com.ruoyi.system.domain.SysNotice;
import com.ruoyi.system.service.ISysMqService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author oweson
 * @date 2022/9/3 23:02
 */

@Component
@Slf4j
public class NoticeListener {
    @Resource
    protected ISysMqService sysMqService;

    @Resource

    protected RedisTemplate redisTemplate;

    @RabbitListener(queues = "fanout.notice_queue1")
    public void listenFanoutQueue1(Message message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag) throws IOException {


        String messageId = (String) message.getMessageProperties().getHeader("spring_returned_message_correlation");

        log.info("MyConsumer  消费者收到消息:{}", JSONObject.toJSONString(message));
        // String messageId = message.getMessageProperties().getCorrelationId();
        String msg = new String(message.getBody(), "UTF-8");


        // 还原之前的类

        SysNotice sysNotice = JSON.parseObject(msg, SysNotice.class);


        String redisMessage = (String) redisTemplate.opsForValue().get("notice:" + messageId);

        if (Objects.nonNull(redisMessage)) {
            // 防止重复消费！
            log.warn("消息已经消费了，不需要重新消费：【{}】", JSONObject.toJSONString(message));
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            return;
        }

        boolean flag = true;
        SysMq sysMq = new SysMq();
        sysMq.setContent(msg);
        sysMq.setStatus("1");
        sysMq.setModule("notice");
        sysMq.setApplication("ruoyi-vue");
        sysMq.setSearchValue("");
        sysMq.setCreateBy("");
        sysMq.setCreateTime(new Date());
        sysMq.setUpdateBy("");
        sysMq.setUpdateTime(new Date());
        sysMq.setRemark("rabbitmq!");
        try {
            sysMqService.insertSysMq(sysMq);
            redisTemplate.opsForValue().set("notice:" + messageId, messageId, 7200L, TimeUnit.SECONDS);
        } catch (Exception e) {
            // 拒绝消息。
            //第2个参数如果设为true，则表示批量拒绝当前通道中所有deliveryTag小于当前消息的所有消息。
            //第3个参数如果设为true，则表示当前消息再次回到队列中等待被再次消费
            channel.basicNack(deliveryTag, true, true);

            flag = false;

        } finally {
            if (flag) {
                // 确认消息。
                //第2个参数如果设为true，则表示批量确认当前通道中所有deliveryTag小于当前消息的所有消息。
                channel.basicAck(deliveryTag, false);

            }
        }


        // long deliveryTag 消息接收tag boolean multiple 是否批量确认
        System.out.println("deliveryTag=" + deliveryTag);

        /**
         * 无异常就确认消息
         * basicAck(long deliveryTag, boolean multiple)
         * deliveryTag:取出来当前消息在队列中的的索引;
         * multiple:为true的话就是批量确认,如果当前deliveryTag为5,那么就会确认
         * deliveryTag为5及其以下的消息;一般设置为false
         */

        if (deliveryTag == 5) {
            channel.basicAck(deliveryTag, true);
        }

    }

}
