package com.api.market.persistence.crud;

import java.util.Optional;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.api.market.persistence.entity.Compra;

public interface CompraCrudRepository extends CrudRepository<Compra, Integer>{
  Optional<List<Compra>> findByIdCliente(String idCliente);
}
