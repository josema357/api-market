package com.api.market.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.api.market.domain.model.BuyItem;
import com.api.market.persistence.entity.ComprasProducto;


@Mapper(componentModel = "spring" ,uses = {ProductMapper.class})
public interface BuyItemMapper {
  @Mappings({
    @Mapping(source = "id.idProducto", target = "id"),
    @Mapping(source = "cantidad", target = "quantity"),
    @Mapping(source = "total", target = "total"),
    @Mapping(source = "estado", target = "status")
  })
  BuyItem toBuyItem(ComprasProducto producto);
  
  @InheritInverseConfiguration
  @Mappings({
    @Mapping(target = "compra", ignore = true),
    @Mapping(target = "producto", ignore = true),
    @Mapping(target = "id.idCompra", ignore = true)
  })
  ComprasProducto toComprasProducto(BuyItem item);
}
