package com.example.demo;
import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;
public class Kafka_Config {
@Bean
public KafkaTemplate<String, String> kafkatemp(){
return new KafkaTemplate<> (producerfactory());
}
@Bean
public ProducerFactory<String, String> producerfactory(){

Map<String, Object> configprop=new HashMap<String,Object>();
configprop.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092") ;
configprop.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
configprop.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
return new DefaultKafkaProducerFactory<>(configprop);
}
}