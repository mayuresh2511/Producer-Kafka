package com.example.producerKafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

  @Autowired
  private  KafkaTemplate<String, EmployeeDTO> kafkaTemplate;


  @PostMapping("/api/message")
  public void getEmployeeDetails(@RequestBody EmployeeDTO employee){
    kafkaTemplate.send("my_first", employee);
  }
}
