package com.market.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.market.domain.model.DomainBuysProductPK;
import com.market.persistence.entity.BuysProductPK;

@Mapper(componentModel = "spring")
public interface BuysProductPKMapper {
  @Mappings({
    @Mapping(source = "buyId", target = "buyId"),
    @Mapping(source = "productId", target = "productId"),
  })
  DomainBuysProductPK toDomainBuysProductPK(BuysProductPK buysProductPK);
  
  @InheritInverseConfiguration
  BuysProductPK toBuysProductPK(DomainBuysProductPK domainBuysProductPK);
}
