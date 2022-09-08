package com.ruoyi.system.demo.demo;

import com.ruoyi.common.constant.KafkaConstants;
import com.ruoyi.system.domain.kafka.Demo01Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Demo01Consumer {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @KafkaListener(topics = KafkaConstants.TOPIC_DEMO_01,
            groupId = "demo01-consumer-group-" + KafkaConstants.TOPIC_DEMO_01)
    public void onMessage(Demo01Message message) {
        logger.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
    }

}
