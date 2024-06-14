package com.api.market.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {
  private String id;
  private String name;
  private String lastName;
  private Integer phone;
  private String address;
  private String email;
}
