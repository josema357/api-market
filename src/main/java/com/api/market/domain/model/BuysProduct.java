package com.api.market.domain.model;

import java.math.BigDecimal;

import jakarta.persistence.EmbeddedId;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BuysProduct {
  @EmbeddedId
  private BuysProductPK id;
  private Integer amount;
  private BigDecimal total;
  private Boolean status;
  private Buy buy;
  private Product product;
}
