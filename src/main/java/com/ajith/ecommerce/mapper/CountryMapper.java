package com.ajith.ecommerce.mapper;

import com.ajith.ecommerce.dto.CountryDto;
import com.ajith.ecommerce.model.Country;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CountryMapper {
    CountryDto toDto(Country country);
    List<CountryDto> toDtoList(List<Country> countryList);
}
