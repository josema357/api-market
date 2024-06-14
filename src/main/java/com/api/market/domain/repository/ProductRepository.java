package com.api.market.domain.repository;

import java.util.List;
import java.util.Optional;

import com.api.market.domain.model.Product;

public interface ProductRepository {
  List<Product> getAll();
  Optional<List<Product>> getByCategory(int categoryId);
  Optional<List<Product>> getScarseProducts(int quantity);
  Optional<Product> getProduct(int id);
  Product save(Product product);
  void delete(int productId);
}
