package com.ajith.ecommerce.service.serviceImpl;

import com.ajith.ecommerce.controller.CityService;
import com.ajith.ecommerce.dto.CityDto;
import com.ajith.ecommerce.dto.SaveCityDto;
import com.ajith.ecommerce.exception.ResourceNotFoundException;
import com.ajith.ecommerce.model.City;
import com.ajith.ecommerce.model.Country;
import com.ajith.ecommerce.repository.CityRepository;
import com.ajith.ecommerce.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;

    @Override
    public String saveCity(SaveCityDto saveCityDto) {
        Country country = countryRepository.findById(saveCityDto.getCountryId()).orElseThrow(() -> new ResourceNotFoundException("country not found with Id : %s".formatted(saveCityDto.getCountryId()), List.of("enter a valid country id")));
        country.getCities().add(City.builder().name(saveCityDto.getName()).build());
        return "city saved successfully";
    }

    @Override
    public List<CityDto> getCitiesByCountryId(UUID id) {
        Country country = countryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("country not found with Id : %s".formatted(id), List.of("enter a valid country id")));

        return country.getCities().stream()
                .map(city ->
                        CityDto.builder().id(city.getId()).name(city.getName()).build())
                .toList();
    }

    @Override
    public String updateCity(String name, UUID id) {
        City city = cityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("city not found with id %s".formatted(id), List.of("enter a valid city Id")));
        city.setName(name);
        cityRepository.save(city);
        return "city updated success fully";
    }

    @Override
    public String deleteCity(UUID id) {
        if (cityRepository.existsById(id)) {
            cityRepository.deleteById(id);
            return "city deleted success fully";
        }
        throw new ResourceNotFoundException("city not found with id : %s".formatted(id), List.of("enter a valid city id"));
    }
}
