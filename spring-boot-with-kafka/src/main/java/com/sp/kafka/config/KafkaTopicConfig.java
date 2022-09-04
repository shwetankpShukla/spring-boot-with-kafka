package com.sp.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/*************************************
 * This Class is used to
 * Author  : Shwetank Shukla
 * File    : com.sp.kafka.config.KafkaTopicConfig
 *
 Date    : 03 September 2022
 * Version : 1.0
 **************************************/

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic amigoscodeTopic(){
        return TopicBuilder.name("amigoscode").build();
    }
}
