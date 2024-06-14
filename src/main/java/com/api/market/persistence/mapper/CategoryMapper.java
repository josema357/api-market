package com.api.market.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.api.market.domain.model.Category;
import com.api.market.persistence.entity.Categoria;


@Mapper(componentModel = "spring")
public interface CategoryMapper {
  @Mappings({
    @Mapping(source = "id", target = "id"),
    @Mapping(source = "descripcion", target= "category"),
    @Mapping(source = "estado", target= "status")
  })
  Category toCategory(Categoria categoria);

  @InheritInverseConfiguration
  @Mapping(target = "productos", ignore = true)
  Categoria toCategoria(Category domainCategory);
}
