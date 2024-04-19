package com.market.persistence.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "buys")
@Getter
@Setter
public class Buy {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(name = "customer_id")
  private String customerId;
  private LocalDateTime date;
  @Column(name = "payment_method")
  private String paymentMethod;
  private String comment;
  private String status;

  @ManyToOne
  @JoinColumn(name = "customer_id" , insertable = false, updatable = false)
  private Customer customer;

  @OneToMany(mappedBy = "buy")
  private List<BuysProduct> products;
}
