package com.api.market.persistence.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "productos")
@Getter
@Setter
public class Producto {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String nombre;
  @Column(name = "id_categoria")
  private Integer idCategoria;
  @Column(name = "codigo_barras")
  private String codigoBarras;
  private BigDecimal precio;
  private Integer cantidad;
  private Boolean estado;

  @ManyToOne
  @JoinColumn(name = "id_categoria" , insertable = false, updatable = false)
  private Categoria categoria;
}
