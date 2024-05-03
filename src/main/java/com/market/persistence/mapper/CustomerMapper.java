package com.market.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.market.domain.model.DomainCustomer;
import com.market.persistence.entity.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
  @Mappings({
    @Mapping(source = "id" , target = "id"),
    @Mapping(source = "name", target = "name"),
    @Mapping(source = "lastName", target = "lastName"),
    @Mapping(source = "phone" , target = "phone"),
    @Mapping(source = "address", target = "address"),
    @Mapping(source = "email", target = "email")
  })
  DomainCustomer toDomainCustomer(Customer customer);

  @InheritInverseConfiguration
  @Mapping(target = "buys", ignore = true)
  Customer toCustomer(DomainCustomer domainCustomer);
}
