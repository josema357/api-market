package com.api.market.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.api.market.domain.model.Buy;
import com.api.market.domain.repository.BuyRepository;
import com.api.market.persistence.crud.CompraCrudRepository;
import com.api.market.persistence.entity.Compra;
import com.api.market.persistence.mapper.BuyMapper;

@Repository
public class CompraRepository implements BuyRepository{
  private CompraCrudRepository compraCrudRepository;
  private BuyMapper mapper;

  /**
   * Constructor-based injection 
   * No necessary @Autowired annotation because of the single constructor
   * @param productCrudRepository repository
   * @param mapper product mapper
   */
  CompraRepository(CompraCrudRepository compraCrudRepository, BuyMapper mapper){
    this.compraCrudRepository = compraCrudRepository;
    this.mapper = mapper;
  }


  @Override
  public List<Buy> getAll() {
    return mapper.toBuys((List<Compra>)compraCrudRepository.findAll());
  }

  @Override
  public Optional<List<Buy>> getByCustomer(String clientId) {
    return compraCrudRepository.findByIdCliente(clientId).map(compras -> mapper.toBuys(compras));
  }

  @Override
  public Buy save(Buy buy) {
    Compra compra = mapper.toCompra(buy);
    compra.getProductos().forEach(producto -> producto.setCompra(compra));
    return mapper.toBuy(compraCrudRepository.save(compra));
  }
  
}
