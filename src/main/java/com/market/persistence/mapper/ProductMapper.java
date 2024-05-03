package com.market.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.market.domain.model.DomainProduct;
import com.market.persistence.entity.Product;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {
  @Mappings({
    @Mapping(source = "id", target = "id"),
    @Mapping(source = "name", target = "product"),
    @Mapping(source = "idCategory", target = "idCategory"),
    @Mapping(source = "price", target = "price"),
    @Mapping(source = "stock", target = "amount"),
    @Mapping(source = "status", target = "active"),
    @Mapping(source = "category", target = "category")
  })
  DomainProduct toDomainProduct(Product product);
  List<DomainProduct> toDomainProducts(List<Product> products);
  @InheritInverseConfiguration
  @Mapping(target="barcode", ignore = true)
  Product toProduct(DomainProduct domainProduct);
}
