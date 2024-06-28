package com.api.market.domain.model;

import java.time.LocalDateTime;
import java.util.List;

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
  private List<BuyItem> items;
}
