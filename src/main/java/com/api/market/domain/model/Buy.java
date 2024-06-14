package com.api.market.domain.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Buy {
  private Integer id;
  private String customerId;
  private LocalDateTime date;
  private String paymentMethod;
  private String comment;
  private String status;
  private Customer customer;
}
