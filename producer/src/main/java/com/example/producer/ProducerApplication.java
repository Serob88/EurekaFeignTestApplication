package com.example.producer;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@EnableScheduling
public class ProducerApplication {

  @Lazy
  private final EurekaClient eurekaClient;

  public ProducerApplication(@Qualifier("eurekaClient") EurekaClient eurekaClient) {
    this.eurekaClient = eurekaClient;
  }

  public static void main(String[] args) {
    SpringApplication.run(ProducerApplication.class, args);
  }

  @RequestMapping({"/actuator/info"})
  public String hello() {
    return "Hello World from TestApplication Class";
  }

  @Bean
  public RestTemplate getRestTemplate() {
    return new RestTemplate();
  }
}

