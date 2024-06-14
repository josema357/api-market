package com.api.market.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.api.market.domain.model.BuysProduct;
import com.api.market.persistence.entity.ComprasProducto;


@Mapper(componentModel = "spring" ,uses = {BuysProductPKMapper.class, BuyMapper.class, ProductMapper.class})
public interface BuysProductMapper {
  @Mappings({
    @Mapping(source = "id", target = "id"),
    @Mapping(source = "cantidad", target = "amount"),
    @Mapping(source = "total", target = "total"),
    @Mapping(source = "estado", target = "status"),
    @Mapping(source = "compra", target = "buy"),
    @Mapping(source = "producto", target = "product")
  })
  BuysProduct toBuysProduct(ComprasProducto comprasProducto);
  
  @InheritInverseConfiguration
  ComprasProducto toComprasProducto(BuysProduct buysProduct);
}
