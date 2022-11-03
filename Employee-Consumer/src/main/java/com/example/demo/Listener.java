package com.example.demo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {
	
	@KafkaListener(topics="Employee_Topic",groupId="consumer-group")
	
	public void consume(String msg) {
		System.out.println("Message consumed by consumer is "+msg);
		
	}
}
