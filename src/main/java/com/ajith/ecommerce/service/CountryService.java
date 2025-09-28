package com.ajith.ecommerce.service;

import com.ajith.ecommerce.dto.CountryDto;

import java.util.List;
import java.util.UUID;

public interface CountryService {
    String saveCounry(String country);

    List<CountryDto> getAllcountry();

    String updateCountry(UUID id, String country);

    String deleteCountryById(UUID id);
}
