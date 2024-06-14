package com.api.market.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.api.market.domain.model.Product;
import com.api.market.domain.repository.ProductRepository;
import com.api.market.persistence.crud.ProductoCrudRespository;
import com.api.market.persistence.entity.Producto;
import com.api.market.persistence.mapper.ProductMapper;

@Repository
public class ProductoRepository implements ProductRepository {
  private ProductoCrudRespository productoCrudRespository;
  private ProductMapper mapper;

  /**
   * Constructor-based injection 
   * No necessary @Autowired annotation because of the single constructor
   * @param productCrudRepository repository
   * @param mapper product mapper
   */
  ProductoRepository(ProductoCrudRespository productoCrudRespository, ProductMapper productMapper){
    this.productoCrudRespository = productoCrudRespository;
    this.mapper = productMapper;
  }

  @Override
  public List<Product> getAll() {
    List<Producto> productos = (List<Producto>) productoCrudRespository.findAll();
    return mapper.toProducts(productos);
  }

  @Override
  public Optional<List<Product>> getByCategory(int categoryId) {
    List<Producto> productos = productoCrudRespository.findByIdCategoriaOrderByNameAsc(categoryId);
    return Optional.of(mapper.toProducts(productos));
  }

  @Override
  public Optional<List<Product>> getScarseProducts(int quantity) {
    Optional<List<Producto>> productos = productoCrudRespository.findByCantidadLessThanAndEstado(quantity, false);
    return productos.map(prods -> mapper.toProducts(prods));
  }

  @Override
  public Optional<Product> getProduct(int id) {
    return productoCrudRespository.findById(id).map(producto -> mapper.toProduct(producto));
  }

  @Override
  public Product save(Product product) {
    Producto producto = mapper.toProducto(product);
    return mapper.toProduct(productoCrudRespository.save(producto));
  }

  @Override
  public void delete(int productId) {
    productoCrudRespository.deleteById(productId);
  }
}
