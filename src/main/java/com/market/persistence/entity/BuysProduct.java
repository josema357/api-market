package com.market.persistence.entity;

import java.math.BigDecimal;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "buys_products")
@Getter
@Setter
public class BuysProduct {
  @EmbeddedId
  private BuysProductPK id;
  private Integer amount;
  private BigDecimal total;
  private Boolean status;
}
