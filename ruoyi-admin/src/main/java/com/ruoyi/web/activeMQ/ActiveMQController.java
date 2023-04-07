package com.ruoyi.web.activeMQ;

import com.ruoyi.common.core.domain.AjaxResult;
import domain.ActiveMQDomain;
import org.apache.activemq.command.ActiveMQMessage;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

import javax.jms.Destination;
import javax.jms.TextMessage;
import java.util.Objects;


@RestController
@RequestMapping("/xxdl")
//消息的发送者
public class ActiveMQController {


    @Autowired
    private JmsTemplate jmsTemplate;

    /**
     * 发送消息
     * @param activeMQDomain
     * @return
     */
    @PostMapping("/send")
    public AjaxResult sendMsg(@RequestBody ActiveMQDomain activeMQDomain)  {

        //订阅模式
       // Destination destination=new ActiveMQTopic(activeMQDomain.getQueueName());

        //PSP点对点模式
         Destination destination=new ActiveMQQueue(activeMQDomain.getQueueName());

        //创建并发送消息
        jmsTemplate.convertAndSend(
                destination
                , activeMQDomain.getContent()
        );


        return AjaxResult.success();

    }


    /**
     * 接收消息
     * @param queueName
     * @return
     */
    @GetMapping("/linstener")
    public AjaxResult receiveMsg(String queueName) {

        //订阅   -     队列
        Object msg = jmsTemplate.receiveAndConvert("user");


        if (!Objects.isNull(msg)) {
            System.out.println(msg);
            return AjaxResult.success(msg);
           // System.out.println();
        }
        return  AjaxResult.success();
    }




}
