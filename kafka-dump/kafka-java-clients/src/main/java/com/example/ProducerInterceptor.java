package com.example;

import java.util.Map;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

public class ProducerInterceptor implements org.apache.kafka.clients.producer.ProducerInterceptor<String, String> {

    @Override
    public void configure(Map<String, ?> configs) {
        // TODO Auto-generated method stub
    }

    @Override
    public ProducerRecord<String, String> onSend(ProducerRecord<String, String> record) {
        // TODO Auto-generated method stub
        //...
        System.out.println(">>>>>>>>>>>>>>>>");
        record.headers().add("header-key", "header-value".getBytes());
        return record;
    }

    @Override
    public void onAcknowledgement(RecordMetadata metadata, Exception exception) {
        // TODO Auto-generated method stub
        System.out.println("<<<<<<<<<<<<<<<<");
    }

    @Override
    public void close() {
        // TODO Auto-generated method stub
    }
    
}
