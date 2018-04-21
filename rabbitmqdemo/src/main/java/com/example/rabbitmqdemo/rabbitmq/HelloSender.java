package com.example.rabbitmqdemo.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * 消息发送者
 *
 * @author itguang
 * @create 2018-04-21 10:46
 **/

@Component
public class HelloSender {


    @Autowired
    private AmqpTemplate amqpTemplate;


    public void send(){
        String context = "hello----"+LocalDateTime.now();
        System.out.println("send:"+context);
        this.amqpTemplate.convertAndSend("hello",context);
    }


    public void send2(int i){
        String context = i+"";
        System.out.println(context+"--send:");
        this.amqpTemplate.convertAndSend("hello2",context);
    }
}
