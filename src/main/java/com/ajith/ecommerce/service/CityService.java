package com.ajith.ecommerce.service;

import com.ajith.ecommerce.dto.CityDto;
import com.ajith.ecommerce.dto.SaveCityDto;

import java.util.List;
import java.util.UUID;

public interface CityService {
    String saveCity(SaveCityDto saveCityDto);

    List<CityDto> getCitiesByCountryId(UUID id);

    String updateCity(String name, UUID id);

    String deleteCity(UUID id);
}
