package com.ruoyi.system.listener;
import com.ruoyi.system.domain.SysMq;
import com.ruoyi.system.service.ISysMqService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author oweson
 * @date 2022/9/3 23:02
 */

@Component
public class NoticeListener {
    @Resource

    protected ISysMqService sysMqService;

    @RabbitListener(queues = "fanout.notice_queue1")
    public void listenFanoutQueue1(String msg) {
        System.out.println("消费者接收到fanout.queue1的消息：【" + msg + "】");

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
        sysMqService.insertSysMq(sysMq);

    }

}
