package com.api.market.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.api.market.domain.model.Product;
import com.api.market.persistence.entity.Producto;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {
  @Mappings({
    @Mapping(source = "id", target = "id"),
    @Mapping(source = "nombre", target = "name"),
    @Mapping(source = "idCategoria", target = "categoryId"),
    @Mapping(source = "precio", target = "price"),
    @Mapping(source = "cantidad", target = "amount"),
    @Mapping(source = "estado", target = "status"),
    @Mapping(source = "categoria", target = "category")
  })
  Product toProduct(Producto producto);
  List<Product> toProducts(List<Producto> productos);
  @InheritInverseConfiguration
  @Mapping(target="codigoBarras", ignore = true)
  Producto toProducto(Product product);
}
