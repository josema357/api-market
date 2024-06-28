package com.api.market.persistence.mapper;
 
import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.api.market.domain.model.Buy;
import com.api.market.persistence.entity.Compra;

@Mapper(componentModel = "spring", uses = {BuyItemMapper.class})
public interface BuyMapper {
  @Mappings({
    @Mapping(source = "id", target = "id"),
    @Mapping(source = "idCliente", target = "customerId"),
    @Mapping(source = "fecha", target = "date"),
    @Mapping(source = "metodoPago", target = "paymentMethod"),
    @Mapping(source = "comentario", target = "comment"),
    @Mapping(source = "estado", target = "status"),
    @Mapping(source = "productos", target = "items")
  })
  Buy toBuy(Compra compra);

  List<Buy> toBuys(List<Compra> compras);

  @InheritInverseConfiguration
  @Mapping(target = "cliente", ignore = true)
  Compra toCompra(Buy buy);
}
