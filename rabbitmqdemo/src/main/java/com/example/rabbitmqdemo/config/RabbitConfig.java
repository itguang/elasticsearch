package com.example.rabbitmqdemo.config;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitMQ 配置类
 *
 * @author itguang
 * @create 2018-04-21 10:24
 **/
@Configuration
public class RabbitConfig {



    @Bean
    public Queue queue(){
        return new Queue("hello");
    }

    @Bean
    public Queue queue2(){
        return new Queue("hello2");
    }

    @Bean
    public Queue queue3(){
        return new Queue("object_queue");
    }



}
