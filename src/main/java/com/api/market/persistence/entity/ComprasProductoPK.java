package com.api.market.persistence.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class ComprasProductoPK implements Serializable {
  @Column(name = "id_compra")
  private Integer idCompra;
  @Column(name = "id_producto")
  private Integer idProducto;
}
