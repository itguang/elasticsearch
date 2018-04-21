package com.example.rabbitmqdemo.object;

import com.example.rabbitmqdemo.pojo.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author itguang
 * @create 2018-04-21 15:51
 **/
@Component
@RabbitListener(queues = "object_queue")
public class ObjectReceiver {

    @RabbitHandler
    public void objectReceiver(User user){

        System.out.println("Receiver object:"+user.toString());

    }
}
