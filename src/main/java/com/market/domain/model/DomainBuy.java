package com.market.domain.model;

import java.time.LocalDateTime;

import com.market.persistence.entity.Customer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DomainBuy {
  private Integer id;
  private String customerId;
  private LocalDateTime date;
  private String paymentMethod;
  private String comment;
  private String status;
  private Customer customer;
}
