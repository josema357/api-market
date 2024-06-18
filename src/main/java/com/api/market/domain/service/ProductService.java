package com.api.market.domain.service;

import org.springframework.stereotype.Service;

import com.api.market.domain.model.Product;
import com.api.market.domain.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
  private ProductRepository productRepository;

  /**
   * Constructor-based injection 
   * No necessary @Autowired annotation because of the single constructor
   * @param productRepository repository
   */
  ProductService(ProductRepository productRepository){
    this.productRepository = productRepository;
  }

  public List<Product> getAll(){
    return productRepository.getAll();
  }

  public Optional<Product> getProduct(int productId){
    return productRepository.getProduct(productId);
  }

  public Optional<List<Product>> getByCategory(int categoryId){
    return productRepository.getByCategory(categoryId);
  }

  public Product save(Product product){
    return productRepository.save(product);
  }

  public boolean delete(int productId){
    return getProduct(productId).map(product -> {
      productRepository.delete(productId);
      return true;
    }).orElse(false);

  }
}
