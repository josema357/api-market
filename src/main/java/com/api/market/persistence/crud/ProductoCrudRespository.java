package com.api.market.persistence.crud;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

import com.api.market.persistence.entity.Producto;

public interface ProductoCrudRespository extends CrudRepository<Producto, Integer> {
  List<Producto> findByIdCategoria(int idCategoria);
  List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);
  Optional<List<Producto>> findByCantidadLessThanAndEstado(int stock, boolean status);
}
