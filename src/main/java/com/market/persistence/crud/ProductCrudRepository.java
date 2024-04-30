package com.market.persistence.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.market.persistence.entity.Product;

public interface ProductCrudRepository extends CrudRepository<Product, Integer>{
  List<Product> findByIdCategory(int idCategory);
  List<Product> findByIdCategoryOrderByNameAsc(int idCategory);
  Optional<List<Product>> findByStockLessThanAndStatus(int stock, boolean status);
}
