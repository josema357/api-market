package com.market.domain.repository;

import java.util.List;
import java.util.Optional;

import com.market.domain.model.DomainProduct;

public interface ProductRepository {
  List<DomainProduct> getAll();
  Optional<List<DomainProduct>> getByCategory(int category);
  Optional<List<DomainProduct>> getProduct(int id);
}
