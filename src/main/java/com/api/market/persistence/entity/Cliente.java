package com.api.market.persistence.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "clientes")
@Getter
@Setter
public class Cliente {
  @Id
  @Column(unique = true)
  private String id;
  private String nombre;
  private String apellido;
  private Long telefono;
  private String direccion;
  private String correo;

  @OneToMany(mappedBy = "cliente")
  private List<Compra> compras;
}
