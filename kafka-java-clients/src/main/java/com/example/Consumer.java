package com.example;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Consumer {
    public static void main(String[] args) throws Exception {


        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "group4");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
        
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);

        consumer.subscribe(java.util.Collections.singletonList("topic1"));

        // add a shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            consumer.wakeup();
        }));

        try{
            while (true) {
                //System.out.println("polling");
                ConsumerRecords<String, String> records = consumer.poll(java.time.Duration.ofMillis(1000));
                //System.out.println("records count: " + records.count());
                records.forEach(record -> {
                    // print topic, partition, offset
                    System.out.println(record.topic() + "\t" + record.partition() + "\t" + record.offset() );
                });
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (WakeupException e){
            //...
        } finally {
            System.out.println("closing consumer");
            consumer.close(); // leave the group
        }


        
    }
}
