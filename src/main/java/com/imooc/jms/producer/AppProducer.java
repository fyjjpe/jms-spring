package com.imooc.jms.producer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/8/2.
 */
public class AppProducer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("producer.xml");
        ProducerServie servie = context.getBean(ProducerServie.class);
        for (int i = 0; i < 100; i++) {
            servie.sendMessage("text" + i);
        }
        context.close();
    }
}
