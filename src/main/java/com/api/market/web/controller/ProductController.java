package com.api.market.web.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.market.domain.model.Product;
import com.api.market.domain.service.ProductService;

import java.util.List;
import java.util.Optional;

@RequestMapping("/products")
@RestController
public class ProductController {
  private ProductService productService;

  /**
   * Constructor-based injection 
   * No necessary @Autowired annotation because of the single constructor
   * @param productService service
   */
  ProductController(ProductService productService){
    this.productService = productService;
  }
  
  @GetMapping("/")
  public List<Product> getAll(){
    return productService.getAll();
  }

  @GetMapping("/{id}")
  public Optional<Product> getProduct(@PathVariable("id") int productId){
    return productService.getProduct(productId);
  }

  @GetMapping("/category/{categoryId}")
  public Optional<List<Product>> getByCategory(@PathVariable("categoryId") int categoryId){
    return productService.getByCategory(categoryId);
  }

  @PostMapping("/save")
  public Product save(@RequestBody Product product){
    return productService.save(product);
  }

  @DeleteMapping("/delete/{id}")
  public boolean delete(@PathVariable("id") int productId){
    return productService.delete(productId);
  }
}
