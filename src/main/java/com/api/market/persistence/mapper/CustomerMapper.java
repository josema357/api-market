package com.api.market.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.api.market.domain.model.Customer;
import com.api.market.persistence.entity.Cliente;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
  @Mappings({
    @Mapping(source = "id" , target = "id"),
    @Mapping(source = "nombre", target = "name"),
    @Mapping(source = "apellido", target = "lastName"),
    @Mapping(source = "telefono" , target = "phone"),
    @Mapping(source = "direccion", target = "address"),
    @Mapping(source = "correo", target = "email")
  })
  Customer toCustomer(Cliente cliente);

  @InheritInverseConfiguration
  @Mapping(target = "compras", ignore = true)
  Cliente toCliente(Customer customer);
}
