package com.example.producer.controller;

import com.example.client.pojo.Product;
import com.example.producer.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductServiceController {

  final ProductService productService;

  public ProductServiceController(ProductService productService) {
    this.productService = productService;
  }

  @RequestMapping({"/products"})
  public ResponseEntity<Object> getProduct() {
    return new ResponseEntity(this.productService.getProducts(), HttpStatus.OK);
  }

  @RequestMapping(value = {"/products/{id}"}, method = {RequestMethod.PUT}
  )
  public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
    this.productService.updateProduct(id, product);
    return new ResponseEntity("Product is updated successsfully", HttpStatus.OK);
  }

  @RequestMapping(value = {"/products/{id}"}, method = {RequestMethod.DELETE})
  public ResponseEntity<Object> delete(@PathVariable("id") String id) {
    this.productService.deleteProduct(id);
    return new ResponseEntity("Product is deleted successfully", HttpStatus.OK);
  }

  @RequestMapping(value = {"/products"}, method = {RequestMethod.POST})
  public ResponseEntity<Object> createProduct(@RequestBody Product product) {
    this.productService.createProduct(product);
    return new ResponseEntity("Product is created successfully", HttpStatus.CREATED);
  }
}

