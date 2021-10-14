package com.example.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ProducerApplication")
public interface ProductRestConsumer {

  @GetMapping({"/products"})
  ResponseEntity<Object> getProduct();

  @PutMapping({"/products/{id}"})
  ResponseEntity<String> updateProduct(@PathVariable("id") String id, @RequestBody Product product);

  @DeleteMapping({"/products/{id}"})
  ResponseEntity<String> delete(@PathVariable("id") String id);

  @PostMapping({"/products"})
  ResponseEntity<String> createProduct(@RequestBody Product product);
}
