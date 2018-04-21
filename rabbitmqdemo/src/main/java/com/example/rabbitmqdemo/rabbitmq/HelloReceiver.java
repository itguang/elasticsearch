package com.example.rabbitmqdemo.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息接受者
 *
 * @author itguang
 * @create 2018-04-21 10:50
 **/

@Component
@RabbitListener(queues = "hello")
public class HelloReceiver {

    @RabbitHandler
    public void process(String message){
        System.out.println("Receiver:"+message);

    }









}
