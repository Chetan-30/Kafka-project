package com.example.demo;


import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;


@Configuration
@EnableKafka
public class Kafka_Consumer_Config {
	
	@Value("{$kafka.broker.address}")
	
	private String kafkabrokeraddress;
	
	public ConsumerFactory<String,String> consumerfactory(){
		Map<String,Object> configprop = new HashMap<String,Object>();
		
		configprop.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
		configprop.put(ConsumerConfig.GROUP_ID_CONFIG,"consumer-group");
		configprop.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
		configprop.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
		return new DefaultKafkaConsumerFactory<>(configprop);
	}
}
