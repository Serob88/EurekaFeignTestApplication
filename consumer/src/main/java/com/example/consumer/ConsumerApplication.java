package com.example.consumer;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableEurekaClient
@EnableFeignClients
public class ConsumerApplication {

  @Lazy
  private final EurekaClient eurekaClient;

  public ConsumerApplication(@Qualifier("eurekaClient") EurekaClient eurekaClient) {
    this.eurekaClient = eurekaClient;
  }

  public static void main(String[] args) {
    SpringApplication.run(ConsumerApplication.class, args);
  }

  @RequestMapping({"/actuator/info"})
  public String hello() {
    return "Hello World from SpringBootExample2Application Class";
  }
}

