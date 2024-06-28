package com.api.market.domain.repository;

import java.util.List;
import java.util.Optional;

import com.api.market.domain.model.Buy;

public interface BuyRepository {
  List<Buy> getAll();
  Optional<List<Buy>> getByCustomer(String customerId);
  Buy save(Buy buy);
}
