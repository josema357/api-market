package com.api.market.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.api.market.domain.model.BuysProductPK;
import com.api.market.persistence.entity.ComprasProductoPK;


@Mapper(componentModel = "spring")
public interface BuysProductPKMapper {
  @Mappings({
    @Mapping(source = "idCompra", target = "buyId"),
    @Mapping(source = "idProducto", target = "productId"),
  })
  BuysProductPK toBuysProductPK(ComprasProductoPK comprasProductoPK);
  
  @InheritInverseConfiguration
  ComprasProductoPK toBuysProductPK(BuysProductPK buysProductPK);
}
