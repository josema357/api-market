package com.market.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DomainCategory {
  private Integer id;
  private String category;
  private Boolean active;
}
