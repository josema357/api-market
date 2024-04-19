package com.market.persistence.entity;

import java.math.BigDecimal;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

  @ManyToOne
  @JoinColumn(name = "buy_id", insertable = false, updatable = false)
  private Buy buy;

  @ManyToOne
  @JoinColumn(name = "product_id", insertable = false, updatable = false)
  private Product product;
}
