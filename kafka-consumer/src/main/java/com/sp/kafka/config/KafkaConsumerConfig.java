package com.sp.kafka.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

import java.util.HashMap;
import java.util.Map;

/*************************************
 * This Class is used to
 * Author  : Shwetank Shukla
 * File    : com.sp.kafka.config.KafkaProducerConfig
 *
 * Date    : 04 September 2022
 * Version : 1.0
 **************************************/
public class KafkaConsumerConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;


    @Bean
    public Map<String,Object> consumerConfig(){
        Map<String,Object> props =new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServers);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringSerializer.class);
        return props;
    }

    @Bean
    public ConsumerFactory<String,String> kafkaTemplate(ProducerFactory<String,String> producerFactory){
        return new DefaultKafkaConsumerFactory<>(consumerConfig());
    }





    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String,String>> factory(ConsumerFactory<String,String> consumerFactory){
        ConcurrentKafkaListenerContainerFactory<String,String> containerFactory = new ConcurrentKafkaListenerContainerFactory<>();
        containerFactory.setConsumerFactory(consumerFactory);
        return  containerFactory;
    }

}
