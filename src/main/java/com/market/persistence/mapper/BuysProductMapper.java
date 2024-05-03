package com.market.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.market.domain.model.DomainBuysProduct;
import com.market.persistence.entity.BuysProduct;


@Mapper(componentModel = "spring" ,uses = {BuysProductPKMapper.class, BuyMapper.class, ProductMapper.class})
public interface BuysProductMapper {
  @Mappings({
    @Mapping(source = "id", target = "id"),
    @Mapping(source = "amount", target = "amount"),
    @Mapping(source = "total", target = "total"),
    @Mapping(source = "status", target = "status"),
    @Mapping(source = "buy", target = "buy"),
    @Mapping(source = "product", target = "product")
  })
  DomainBuysProduct toDomainBuysProduct(BuysProduct buysProduct);
  
  @InheritInverseConfiguration
  BuysProduct toBuysProduct(DomainBuysProduct domainBuysProduct);
}
