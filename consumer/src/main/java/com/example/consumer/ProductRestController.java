package com.example.consumer;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/demo"})
public class ProductRestController {

  private final ProductRestConsumer consumer;

  public ProductRestController(ProductRestConsumer consumer) {
    this.consumer = consumer;
  }

  @GetMapping({"/products"})
  public String getProductInfo() {
    System.out.println(this.consumer.getClass().getName());
    return "Accessing from DEMO-SERVICE ==> " + this.consumer.getProduct();
  }

  @PutMapping({"/products/{id}"})
  public String updateProductInfo(@PathVariable("id") String id, @RequestBody Product product) {
    System.out.println(this.consumer.getClass().getName());
    return "Accessing from DEMO-SERVICE ==> " + this.consumer.updateProduct(id, product);
  }

  @DeleteMapping({"/products/{id}"})
  public String deleteProductInfo(@PathVariable String id) {
    System.out.println(this.consumer.getClass().getName());
    return "Accessing from DEMO-SERVICE ==> " + this.consumer.delete(id);
  }

  @PostMapping({"/product"})
  public String creatProductInfo(@RequestBody Product product) {
    System.out.println(this.consumer.getClass().getName());
    return "Accessing from DEMO-SERVICE ==> " + this.consumer.createProduct(product);
  }
}
