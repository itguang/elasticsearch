package com.example.rabbitmqdemo.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author itguang
 * @create 2018-04-21 16:26
 **/
@Component
public class TopicSender {

    @Autowired
    AmqpTemplate amqpTemplate;

    public void send1(){
        String context = "hi, i am message 1";
        System.out.println("Sender : " + context);
        amqpTemplate.convertAndSend("topicExchange","topic.message",context);
    }

    public void send2() {
        String context = "hi, i am messages 2";
        System.out.println("Sender : " + context);
        amqpTemplate.convertAndSend("topicExchange", "topic.messages", context);
    }




}
