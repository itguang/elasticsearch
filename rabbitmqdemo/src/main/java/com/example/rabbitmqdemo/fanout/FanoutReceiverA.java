package com.example.rabbitmqdemo.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author itguang
 * @create 2018-04-21 17:15
 **/
@Component
@RabbitListener(queues = "fanout.A")
public class FanoutReceiverA {


    @RabbitHandler
    public void process(String message){

        System.out.println("Receiver form fanout.A: "+message);

    }

}
