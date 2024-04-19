package com.market.persistence.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class BuysProductPK implements Serializable {
  @Column(name = "buy_id")
  private Integer buyId;
  @Column(name = "product_id")
  private Integer productId;
}
