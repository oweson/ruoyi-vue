package mq.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringSimpleAmqpTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSendMessage2SimpleQueue() {
        String queueName = "simple.queue";
        String message = "hello, spring amqp!";
        rabbitTemplate.convertAndSend(queueName, message);
    }

    /**
     * Work Queue 工作队列模型
     * @throws InterruptedException
     */
    @Test
    public void testSendMessage2WorkQueue() throws InterruptedException {
        String queueName = "simple.queue";
        String message = "hello, message__";
        for (int i = 1; i <= 50; i++) {
            rabbitTemplate.convertAndSend(queueName,message+i);
            Thread.sleep(20);
        }
    }

    /**
     * todo Fanout Exchange 会将接收到的消息广播到每一个跟其绑定的queue
     */
    @Test
    public void testSendFanoutExchange() {
        // 1 交换机名称
        String exchangeName = "itcast.fanout";
        // 2 消息
        String message = "hello, every one! I'm oweson!";
        // 3 发送消息
        rabbitTemplate.convertAndSend(exchangeName, "", message);
    }


    /**
     * Direct Exchange 会将接收到的消息根据规则路由到指定的Queue，因此称为路由模式（routes）
     */
    @Test
    public void testSendDirectExchange() {
        // 交换机名称
        String exchangeName = "itcast.direct";
        // 消息
        String message = "hello, red!";
        // 发送消息
        rabbitTemplate.convertAndSend(exchangeName, "red", message);
    }

    /**
     * 区别在于routingKey必须是多个单词的列表
     * Queue与Exchange指定BindingKey时可以使用通配符
     */
    @Test
    public void testSendTopicExchange() {
        // 交换机名称
        String exchangeName = "itcast.topic";
        // 消息
        String message = "今天天气不错，我的心情好极了!";
        // 发送消息
        rabbitTemplate.convertAndSend(exchangeName, "china.weather", message);
    }

    /**
     * 区别在于routingKey必须是多个单词的列表
     * Queue与Exchange指定BindingKey时可以使用通配符
     */
    @Test
    public void testSendTopicExchange2() {
        // 交换机名称
        String exchangeName = "itcast.topic";
        // 消息
        String message = "今天天气不错，我的心情好极了!";
        // 发送消息
        rabbitTemplate.convertAndSend(exchangeName, "hi.news", message);
    }
}
