package com.market.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.market.domain.DomainCategory;
import com.market.persistence.entity.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
  @Mappings({
    @Mapping(source = "id", target = "id"),
    @Mapping(source = "description", target= "category"),
    @Mapping(source = "status", target= "active")
  })
  DomainCategory toDomainCategory(Category category);

  @InheritInverseConfiguration
  @Mapping(target = "products", ignore = true)
  Category toCategory(DomainCategory domainCategory);
}
