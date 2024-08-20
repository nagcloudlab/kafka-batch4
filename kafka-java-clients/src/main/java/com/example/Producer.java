package com.example;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;


public class Producer {
    public static void main(String[] args) throws Exception {

        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, CustomPartitioner.class.getName());

        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        // Send a message
        String topic = "topic1";
        
        // way-1: Synchronous
        // String value = "Hello, Kafka!";
        // ProducerRecord<String, String> record = new ProducerRecord<>(topic, value);
        // Future<RecordMetadata> future = producer.send(record); // Asynchronous
        // try {
        //     RecordMetadata metadata = future.get(); // Blocking
        //     System.out.println("Record sent to partition " + metadata.partition() + " with offset " + metadata.offset());
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }

        // way-2: Asynchronous    
        for (int i = 0; i < 1000000; i++) {
            // 1k sized message
            String value = "Apache Kafka is a distributed event store and stream-processing platform. It is an open-source system developed by the Apache Software Foundation written in Java and Scala. The project aims to provide a unified, high-throughput, low-latency platform for handling real-time data feed\n" +
                "Apache Kafka is a distributed event store and stream-processing platform. It is an open-source system developed by the Apache Software Foundation written in Java and Scala. The project aims to provide a unified, high-throughput, low-latency platform for handling real-time data feed\n" +
                "Apache Kafka is a distributed event store and stream-processing platform. It is an open-source system developed by the Apache Software Foundation written in Java and Scala. The project aims to provide a unified, high-throughput, low-latency platform for handling real-time data feed\n" +
                "Apache Kafka is a distributed event store and stream-processing platform. It is an open-source system developed by the Apache Software Foundation write";
            String key=List.of("key1","key2","key3").get(i%3);    
            ProducerRecord<String, String> record = new ProducerRecord<>(topic,key, value);
            producer.send(record, (metadata, exception) -> {
                if (exception != null) {
                    exception.printStackTrace();
                } else {
                    System.out.println("Record sent to partition " + metadata.partition() + " with offset " + metadata.offset());
                }
            });
            TimeUnit.MILLISECONDS.sleep(1);
        }
        producer.close();

    }
}
