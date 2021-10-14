package com.example.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
public class ProductServiceInterceptorAppConfig extends WebMvcConfigurerAdapter {
  final ProductServiceInterceptor productServiceInterceptor;

  public ProductServiceInterceptorAppConfig(ProductServiceInterceptor productServiceInterceptor) {
    this.productServiceInterceptor = productServiceInterceptor;
  }

  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(this.productServiceInterceptor);
  }
}
