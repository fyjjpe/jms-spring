package com.imooc.jms.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.annotation.Resource;
import javax.jms.*;

/**
 * Created by Administrator on 2017/8/2.
 */
public class ProducerServiceImpl implements ProducerServie {
    @Autowired
    private JmsTemplate jmsTemplate;

//    @Resource(name = "queueDestination")//队列模式
    @Resource(name = "topicDestination")//主题模式
    private Destination destination;

    public void sendMessage(final String message) {
        //使用jmsTemplate发送消息
        jmsTemplate.send(destination, new MessageCreator() {
            //创建一个消息
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage(message);
                return textMessage;
            }
        });
        System.out.println("发送消息：" + message);
    }
}
