package com.example.rabbitmqdemo.many;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 注册多个接受者
 *
 * @author itguang
 * @create 2018-04-21 10:58
 **/
@Component
@RabbitListener(queues = "hello2")
public class HelloReceiver1 {


    @RabbitHandler
    public void process(String message){

        System.out.println("Receiver1:"+message);
    }


}
