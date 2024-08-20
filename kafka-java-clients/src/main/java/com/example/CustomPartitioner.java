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
    public int partition(String arg0, Object arg1, byte[] arg2, Object arg3, byte[] arg4, Cluster arg5) {
        // Custom logic to determine partition
        return 2;
    }
    
}