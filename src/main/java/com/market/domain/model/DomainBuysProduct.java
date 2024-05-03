package com.market.domain.model;

import java.math.BigDecimal; 

import com.market.persistence.entity.Buy;
import com.market.persistence.entity.BuysProductPK;
import com.market.persistence.entity.Product;

import jakarta.persistence.EmbeddedId;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DomainBuysProduct {
  @EmbeddedId
  private BuysProductPK id;
  private Integer amount;
  private BigDecimal total;
  private Boolean status;
  private Buy buy;
  private Product product;
}

