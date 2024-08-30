package com.example;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

public class CustomPartitioner implements Partitioner {

    @Override
    public void close() {
    }

    @Override
    public void configure(java.util.Map<java.lang.String, ?> configs) {
    }

    @Override
    public int partition(String topic, Object key, byte[] keyByte, Object value, byte[] valueByte, Cluster cluster) {
        // Custom logic to determine partition
        return 2;
    }
    
}