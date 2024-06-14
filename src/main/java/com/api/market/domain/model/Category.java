package com.api.market.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category {
  private Integer id;
  private String category;
  private Boolean status;
}
