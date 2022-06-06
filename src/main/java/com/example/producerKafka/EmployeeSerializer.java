package com.example.producerKafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Serializer;

import java.nio.charset.StandardCharsets;
import java.util.Map;

public class EmployeeSerializer implements Serializer {


  @Override
  public void configure(Map configs, boolean isKey) {
    Serializer.super.configure(configs, isKey);
  }

  @Override
  public byte[] serialize(String s, Object o) {
    byte[] reVal = null;
    ObjectMapper newObjectMapper = new ObjectMapper();
    try {
      reVal = newObjectMapper.writeValueAsString(o).getBytes();
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return reVal;
  }


  @Override
  public void close() {
    Serializer.super.close();
  }
}
