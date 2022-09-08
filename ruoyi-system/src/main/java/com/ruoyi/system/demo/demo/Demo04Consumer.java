package com.ruoyi.system.demo.demo;

import com.ruoyi.common.constant.KafkaConstants;
import com.ruoyi.system.domain.kafka.Demo04Message;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
@Slf4j
public class Demo04Consumer {

    private AtomicInteger count = new AtomicInteger(0);

    private Logger logger = LoggerFactory.getLogger(getClass());

    @KafkaListener(topics = KafkaConstants.TOPIC_DEMO_04,
            groupId = "demo04-consumer-group-" + KafkaConstants.TOPIC_DEMO_04)
    public void onMessage(Demo04Message message) {
        logger.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
        // 注意，此处抛出一个 RuntimeException 异常，模拟消费失败
        throw new RuntimeException("我就是故意抛出一个异常");
    }

}
