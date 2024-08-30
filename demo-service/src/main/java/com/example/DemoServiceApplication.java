package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@SpringBootApplication
@RestController
public class DemoServiceApplication {


	@Bean
	public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate<String, String> template = new RedisTemplate<>();
		template.setConnectionFactory(redisConnectionFactory);
		template.setKeySerializer(new StringRedisSerializer());
		template.setValueSerializer(new StringRedisSerializer());
		return template;
	}

	@Autowired
	private RedisTemplate<String, String> redisTemplate;


	//String requestCount="0"; // data service's in-memory data 

	// GET /hello/{name}
	// Returns a greeting message with request count
	@GetMapping("/hello/{name}")
	public String getMethodName(@PathVariable String name) {
		//requestCount = Integer.toString(Integer.parseInt(requestCount)+1);
		Long requestCount = redisTemplate.opsForValue().increment("request:count",1);
		return "Hello "+name+"! Request count: "+requestCount;
	}
	

	public static void main(String[] args) {
		SpringApplication.run(DemoServiceApplication.class, args);
	}

}
