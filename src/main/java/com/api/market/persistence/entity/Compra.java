package com.api.market.persistence.entity;

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
@Table(name = "compras")
@Getter
@Setter
public class Compra {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(name = "id_cliente")
  private String idCliente;
  private LocalDateTime fecha;
  @Column(name = "metodo_pago")
  private String metodoPago;
  private String comentario;
  private String estado;

  @ManyToOne
  @JoinColumn(name = "id_cliente" , insertable = false, updatable = false)
  private Cliente cliente;

  @OneToMany(mappedBy = "compra")
  private List<ComprasProducto> productos;
}
