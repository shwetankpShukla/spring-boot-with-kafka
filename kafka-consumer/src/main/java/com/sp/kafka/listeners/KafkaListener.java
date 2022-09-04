package com.sp.kafka.listeners;

import org.springframework.stereotype.Component;

/*************************************
 * This Class is used to
 * Author  : Shwetank Shukla
 * File    : com.sp.kafka.listner.KafkaListner
 *
 * Date    : 04 September 2022
 * Version : 1.0
 **************************************/
@Component
public class KafkaListener {

    @org.springframework.kafka.annotation.KafkaListener(topics = "amigoscode",groupId = "SP")
    void listener (String data){
        System.out.println("Data Received for Kafka Server date is ::"+data );

    }


}
