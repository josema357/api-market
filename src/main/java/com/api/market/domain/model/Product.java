package com.api.market.domain.model;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
  private Integer id;
  private String name;
  private Integer categoryId;
  private BigDecimal price;
  private Integer amount;
  private Boolean status;
  private Category category;
}
