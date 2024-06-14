package com.api.market.persistence.entity;

import java.math.BigDecimal;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "compras_productos")
@Getter
@Setter
public class ComprasProducto {
  @EmbeddedId
  private ComprasProductoPK id;
  private Integer cantidad;
  private BigDecimal total;
  private Boolean estado;

  @ManyToOne
  @JoinColumn(name = "id_compra", insertable = false, updatable = false)
  private Compra compra;

  @ManyToOne
  @JoinColumn(name = "id_producto", insertable = false, updatable = false)
  private Producto producto;
}
