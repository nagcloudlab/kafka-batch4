package com.example.order_history_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cassandra.core.cql.CqlTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderHistoryService {

    @Autowired
    private CqlTemplate cqlTemplate;

    @KafkaListener(topics = "order-events", groupId = "order-history-group")
    public void handleOrderPlaced(ConsumerRecord<String, OrderPlacedEvent> record) {
        OrderPlacedEvent event = record.value();

        // Insert the event data into Cassandra
        cqlTemplate.execute("INSERT INTO orders_keyspace.order_history (order_id, user_id, total_amount, order_date) VALUES (?, ?, ?, toTimestamp(now()))",
                UUID.randomUUID(), event.getUserId(), event.getTotalAmount());
    }
}


@SpringBootApplication
public class OrderHistoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderHistoryServiceApplication.class, args);
	}

}
