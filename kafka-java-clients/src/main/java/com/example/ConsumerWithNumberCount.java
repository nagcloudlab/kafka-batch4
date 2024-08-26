package com.example;

import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.List;
import java.util.Properties;

public class ConsumerWithNumberCount {

    public static void main(String[] args) {


        Properties consumerProps = new Properties();
        consumerProps.put("bootstrap.servers", "localhost:9092");
        consumerProps.put("group.id", "group-1");
        consumerProps.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        consumerProps.put("value.deserializer", "org.apache.kafka.common.serialization.LongDeserializer");
        consumerProps.put("auto.offset.reset", "earliest");

        KafkaConsumer<String, Long> consumer = new KafkaConsumer<>(consumerProps);

        // subscribe to topic
        consumer.subscribe(List.of("counted-numbers"));

        // poll for new data
        while (true) {
            consumer.poll(1000).forEach(record -> {
                System.out.println("Key: " + record.key() + ", Value: " + record.value());
            });
        }


    }

}
