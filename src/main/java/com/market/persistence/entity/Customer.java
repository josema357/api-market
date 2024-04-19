package com.market.persistence.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "customers")
@Getter
@Setter
public class Customer {
  @Id
  @Column(unique = true)
  private String id;
  private String name;
  @Column(name = "last_name")
  private String lastName;
  private Integer phone;
  private String address;
  private String email;

  @OneToMany(mappedBy = "customer")
  private List<Buy> buys;
}
