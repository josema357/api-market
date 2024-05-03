package com.market.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.market.domain.model.DomainBuy;
import com.market.persistence.entity.Buy;

@Mapper(componentModel = "spring", uses = {CustomerMapper.class})
public interface BuyMapper {
  @Mappings({
    @Mapping(source = "id", target = "id"),
    @Mapping(source = "customerId", target = "customerId"),
    @Mapping(source = "date", target = "date"),
    @Mapping(source = "paymentMethod", target = "paymentMethod"),
    @Mapping(source = "comment", target = "comment"),
    @Mapping(source = "status", target = "status"),
    @Mapping(source = "customer", target = "customer")
  })
  DomainBuy toDomainBuy(Buy buy);

  @InheritInverseConfiguration
  @Mapping(target = "products", ignore = true)
  Buy toBuy(DomainBuy domainBuy);
}
