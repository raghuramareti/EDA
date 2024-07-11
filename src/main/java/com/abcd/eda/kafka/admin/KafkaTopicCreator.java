package com.abcd.eda.kafka.admin;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.admin.AdminClientConfig;

import java.util.Collections;
import java.util.Properties;

public class KafkaTopicCreator {

    public static void main(String[] args) {
        Properties config = new Properties();
        config.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");

        AdminClient admin = AdminClient.create(config);

        NewTopic newTopic = new NewTopic("my_topic", 1, (short) 1);
        admin.createTopics(Collections.singletonList(newTopic));
        
        admin.close();
    }
}

// ./kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic my_topic