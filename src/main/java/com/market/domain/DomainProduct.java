package com.market.domain;

import java.math.BigDecimal;

import com.market.persistence.entity.Category;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DomainProduct {
  private Integer id;
  private String product;
  private Integer idCategory;
  private BigDecimal price;
  private Integer amount;
  private Boolean active;
  private Category category;
}
