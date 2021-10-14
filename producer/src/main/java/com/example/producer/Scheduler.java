package com.example.producer;

import org.springframework.stereotype.Component;
import com.example.producer.service.consume.ConsumeWebService;

@Component
public class Scheduler {

  final ConsumeWebService consumeWebService;

  public Scheduler(ConsumeWebService consumeWebService) {
    this.consumeWebService = consumeWebService;
  }
}
