package com.example.producer.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.example.producer.pojo.Product;
import com.example.producer.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

  private static Map<String, Product> productRepo = new HashMap();

  public void createProduct(Product product) {
    productRepo.put(product.getId(), product);
  }

  public void updateProduct(String id, Product product) {
    productRepo.remove(id);
    product.setId(id);
    productRepo.put(id, product);
  }

  public void deleteProduct(String id) {
    productRepo.remove(id);
  }

  public Collection<Product> getProducts() {
    return productRepo.values();
  }

  static {
    Product honey = new Product();
    honey.setId("1");
    honey.setName("Honey");
    productRepo.put(honey.getId(), honey);
    Product almond = new Product();
    almond.setId("2");
    almond.setName("Almond");
    productRepo.put(almond.getId(), almond);
  }
}

