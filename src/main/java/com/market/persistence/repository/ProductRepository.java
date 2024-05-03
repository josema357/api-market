package com.market.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.market.domain.model.DomainProduct;
import com.market.domain.repository.DomainProductRepository;
import com.market.persistence.crud.ProductCrudRepository;
import com.market.persistence.entity.Product;
import com.market.persistence.mapper.ProductMapper;

@Repository
public class ProductRepository implements DomainProductRepository{

  private ProductCrudRepository productCrudRepository;
  private ProductMapper mapper;

  /**
   * Constructor-based injection 
   * No necessary @Autowired annotation because of the single constructor
   * @param productCrudRepository repository
   * @param mapper product mapper
   */
  ProductRepository(ProductCrudRepository productCrudRepository, ProductMapper mapper){
    this.productCrudRepository = productCrudRepository;
    this.mapper = mapper;
  }

  @Override
  public List<DomainProduct> getAll() {
    List<Product> products = (List<Product>) productCrudRepository.findAll();
    return mapper.toDomainProducts(products);
  }

  @Override
  public Optional<List<DomainProduct>> getByCategory(int categoryId) {
    List<Product> products = productCrudRepository.findByIdCategoryOrderByNameAsc(categoryId);
    return Optional.of(mapper.toDomainProducts(products));
  }

  @Override
  public Optional<List<DomainProduct>> getScarseProducts(int quantity) {
    Optional<List<Product>> products = productCrudRepository.findByStockLessThanAndStatus(quantity, false);
    return products.map( (product) -> mapper.toDomainProducts(product) );
  }

  @Override
  public Optional<DomainProduct> getProduct(int id) {
    Optional<Product> products = productCrudRepository.findById(id);
    return products.map((product) -> mapper.toDomainProduct(product));
  }

  @Override
  public DomainProduct save(DomainProduct domainProduct) {
    Product product = mapper.toProduct(domainProduct);
    return mapper.toDomainProduct(productCrudRepository.save(product));
  }

  @Override
  public void delete(int productId) {
    productCrudRepository.deleteById(productId);
  }

}
