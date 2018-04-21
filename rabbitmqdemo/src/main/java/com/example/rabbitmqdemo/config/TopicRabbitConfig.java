package com.example.rabbitmqdemo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author itguang
 * @create 2018-04-21 16:10
 **/
@Configuration
public class TopicRabbitConfig {


    final static String message = "topic.message";
    final static String messages = "topic.messages";


    //创建两个 Queue
    @Bean
    public Queue queueMessage(){
        return new Queue(TopicRabbitConfig.message);
    }

    @Bean
    public Queue queueMessages(){
        return new Queue(TopicRabbitConfig.messages);
    }

    //配置 TopicExchange,制定名称为 topicExchange
    @Bean
    public TopicExchange exchange(){
        return new TopicExchange("topicExchange");
    }

    //给队列绑定 exchange 和 routing_key

    @Bean
    public Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange){
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }

    @Bean
    public Binding bingingExchangeMessages(Queue queueMessages,TopicExchange exchange){
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }


}
