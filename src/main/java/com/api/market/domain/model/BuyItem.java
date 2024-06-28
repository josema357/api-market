package com.api.market.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BuyItem {
  private Integer id;
  private Integer quantity;
  private Double total;
  private Boolean status;
}
