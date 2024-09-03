package com.example;

import java.time.Duration;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.errors.WakeupException;

public class ConsumerAndProducer {

    public static void main(String[] args) {

        // consumer
        Properties consumerProperties = new Properties();
        consumerProperties.put("bootstrap.servers", "localhost:9092");
        consumerProperties.put("group.id", "numbers-group");
        consumerProperties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        consumerProperties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        consumerProperties.put("auto.offset.reset", "earliest");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(consumerProperties);

        // producer
        Properties producerProperties = new Properties();
        producerProperties.put("bootstrap.servers", "localhost:9092");
        producerProperties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        producerProperties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        KafkaProducer<String, String> producer = new KafkaProducer<>(producerProperties);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            consumer.wakeup();
        }));

        consumer.subscribe(java.util.Arrays.asList("numbers"));

       try{
         // poll thread
        while (true) {
            System.out.println("Polling...");
            ConsumerRecords<String,String> records=consumer.poll(Duration.ofMillis(1000));
            System.out.println("Received " + records.count() + " records");    
            records.forEach(record -> {
                int value = Integer.parseInt(record.value());
                // filtering...
                if(value % 2 == 0) {
                    producer.send(new ProducerRecord<>("even-numbers", record.key(), record.value()));
                } else {
                    producer.send(new ProducerRecord<>("odd-numbers", record.key(), record.value()));
                }
            });
        }

    } catch (WakeupException e) {
        e.printStackTrace();
    } finally {
        consumer.close();
        producer.close();
    }
    
    }
    
}


// data/stream pocessing

// - filtering
// - transformation
// - aggregation
// - joining
// - windowing
// - stateful processing
// - etc


// to consider

// - fault tolerance
// - scalability
// - real-time processing
// - exactly-once processing
// - etc

// how to implement data processing in Kafka?

// - Kafka Streams

// - java based library
// or
// - KSQL    
