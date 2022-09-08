package mq.kafka;

import com.alibaba.fastjson2.JSON;
import com.ruoyi.common.constant.KafkaConstants;
import com.ruoyi.system.domain.kafka.Demo01Message;
import mq.App;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import javax.annotation.Resource;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

/**
 * @author oweson
 * @date 2022/9/7 23:28
 */


public class KafkaDemoTest extends App {


    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private KafkaTemplate<Object, Object> kafkaTemplate;

    @Test
    public void testSyncSend() throws ExecutionException, InterruptedException {
        int id = (int) (System.currentTimeMillis() / 1000);

        SendResult sendResult = kafkaTemplate.send(KafkaConstants.TOPIC_DEMO_01, JSON.toJSONString(new Demo01Message().setId(id))).get();
        logger.info("[testSyncSend][发送编号：[{}] 发送结果：[{}]]", id, sendResult);

        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }

    @Test
    public void testASyncSend() throws InterruptedException {
        int id = (int) (System.currentTimeMillis() / 1000);
        asyncSend(id).addCallback(new ListenableFutureCallback<SendResult<Object, Object>>() {

            @Override
            public void onFailure(Throwable e) {
                logger.info("[testASyncSend][发送编号：[{}] 发送异常]]", id, e);
            }

            @Override
            public void onSuccess(SendResult<Object, Object> result) {
                logger.info("[testASyncSend][发送编号：[{}] 发送成功，结果为：[{}]]", id, result);
            }

        });

        // 阻塞等待，保证消费
        new CountDownLatch(1).await();
    }


    public ListenableFuture<SendResult<Object, Object>> asyncSend(Integer id) {
        // 创建 Demo01Message 消息
        Demo01Message message = new Demo01Message();
        message.setId(id);
        // 异步发送消息
        return kafkaTemplate.send(Demo01Message.TOPIC, message);
    }
}
