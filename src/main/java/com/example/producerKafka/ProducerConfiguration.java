package com.example.producerKafka;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ProducerConfiguration {

  private static final String KAFKA_BROKER = "localhost:9092";

  @Bean
  public Map<String, Object> configurationProducer(){
    Map<String, Object> configuration = new HashMap<>();
    configuration.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_BROKER);
    configuration.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, EmployeeSerializer.class);
    configuration.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
    return configuration;
  }

  @Bean
  public ProducerFactory<String, EmployeeDTO> producerFactory(){
    return new DefaultKafkaProducerFactory<>(configurationProducer());
  }

  @Bean
  public KafkaTemplate<String, EmployeeDTO> kafkaTemplate(){
    return new KafkaTemplate<>(producerFactory());
  }
}
