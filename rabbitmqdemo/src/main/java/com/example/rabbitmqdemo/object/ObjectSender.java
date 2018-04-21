package com.example.rabbitmqdemo.object;

import com.example.rabbitmqdemo.pojo.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author itguang
 * @create 2018-04-21 15:49
 **/
@Component
public class ObjectSender {



    @Autowired
    AmqpTemplate amqpTemplate;

    public void sendUser(User user){

        System.out.println("Send object:"+user.toString());
        this.amqpTemplate.convertAndSend("object_queue",user);



    }


}
