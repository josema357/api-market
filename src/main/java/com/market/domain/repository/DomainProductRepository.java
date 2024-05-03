package com.market.domain.repository;

import java.util.List;
import java.util.Optional;

import com.market.domain.model.DomainProduct;

public interface DomainProductRepository {
  List<DomainProduct> getAll();
  Optional<List<DomainProduct>> getByCategory(int categoryId);
  Optional<List<DomainProduct>> getScarseProducts(int quantity);
  Optional<DomainProduct> getProduct(int id);
  DomainProduct save(DomainProduct domainProduct);
  void delete(int productId);
}
