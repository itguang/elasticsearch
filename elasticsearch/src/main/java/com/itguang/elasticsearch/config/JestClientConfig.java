package com.itguang.elasticsearch.config;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;

/**
 * @author itguang
 * @create 2018-03-20 11:07
 **/
//@Configuration
public class JestClientConfig {


   // @Bean
    public JestClient getJestClient(){
        // Construct a new Jest client according to configuration via factory
        JestClientFactory factory = new JestClientFactory();
        factory.setHttpClientConfig(new HttpClientConfig
                .Builder("http://localhost:9200")
                .multiThreaded(true)
                //Per default this implementation will create no more than 2 concurrent connections per given route
                .defaultMaxTotalConnectionPerRoute(2)
                // and no more 20 connections in total
                .maxTotalConnection(20)
                        .build());
        JestClient client = factory.getObject();

        return client;

    }



}
