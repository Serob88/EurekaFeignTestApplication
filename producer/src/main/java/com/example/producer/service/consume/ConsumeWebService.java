package com.example.producer.service.consume;

import java.util.Arrays;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.example.producer.pojo.Product;

@RestController
public class ConsumeWebService {

  final RestTemplate restTemplate;

  public ConsumeWebService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @RequestMapping({"/template/products"})
  public String getProductList() {
    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    HttpEntity<String> entity = new HttpEntity(headers);
    return (String)this.restTemplate.exchange("http://localhost:9090/products", HttpMethod.GET, entity, String.class, new Object[0]).getBody();
  }

  @RequestMapping(
      value = {"/template/products"},
      method = {RequestMethod.POST}
  )
  public String createProducts(@RequestBody Product product) {
    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    HttpEntity<Product> entity = new HttpEntity(product, headers);
    return (String)this.restTemplate.exchange("http://localhost:9090/products", HttpMethod.POST, entity, String.class, new Object[0]).getBody();
  }

  @RequestMapping(
      value = {"/template/products/{id}"},
      method = {RequestMethod.PUT}
  )
  public String updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    HttpEntity<Product> entity = new HttpEntity(product, headers);
    return (String)this.restTemplate.exchange("http://localhost:9090/products/" + id, HttpMethod.PUT, entity, String.class, new Object[0]).getBody();
  }

  @RequestMapping(
      value = {"/template/products/{id}"},
      method = {RequestMethod.DELETE}
  )
  public String deleteProduct(@PathVariable("id") String id) {
    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    HttpEntity<Product> entity = new HttpEntity(headers);
    return (String)this.restTemplate.exchange("http://localhost:9090/products/" + id, HttpMethod.DELETE, entity, String.class, new Object[0]).getBody();
  }
}

