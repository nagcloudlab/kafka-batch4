package com.example.order_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


class OrderPlacedEvent {

    private String userId;
    private double totalAmount;

    // Constructor, Getters, and Setters

    public OrderPlacedEvent(String userId, double totalAmount) {
        this.userId = userId;
        this.totalAmount = totalAmount;
    }

    public String getUserId() {
        return userId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}

public class OrderService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private KafkaTemplate<String, OrderPlacedEvent> kafkaTemplate;

    public void placeOrder(String userId, double totalAmount) {
        // Insert the order into PostgreSQL
        jdbcTemplate.update("INSERT INTO orders (user_id, total_amount) VALUES (?, ?)", userId, totalAmount);

        // Create an event and publish it to Kafka
        OrderPlacedEvent event = new OrderPlacedEvent(userId, totalAmount);
        kafkaTemplate.send("order-events", event);
    }
}



@SpringBootApplication
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

}
