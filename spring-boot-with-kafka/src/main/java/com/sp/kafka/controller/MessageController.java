package com.sp.kafka.controller;

import com.sp.kafka.domain.MessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*************************************
 * This Class is used to
 * Author  : Shwetank Shukla
 * File    : com.sp.kafka.controller.MessageController
 *
 * Date    : 04 September 2022
 * Version : 1.0
 **************************************/

@RestController
@RequestMapping("api/v1/messages")
public class MessageController {

    @Autowired
    private KafkaTemplate<String,String > template;

    @PostMapping
    public void publishMessages(@RequestBody MessageRequest messageRequest){
        template.send("amigoscode", messageRequest.message());
    }



}
