package com.abcd.eda.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "my_topic", groupId = "my_group_id")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
    }
}
