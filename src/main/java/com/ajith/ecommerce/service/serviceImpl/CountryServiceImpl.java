package com.ajith.ecommerce.service.serviceImpl;

import com.ajith.ecommerce.dto.CountryDto;
import com.ajith.ecommerce.exception.ResourceAlreadyExistsException;
import com.ajith.ecommerce.exception.ResourceNotFoundException;
import com.ajith.ecommerce.exception.ServiceException;
import com.ajith.ecommerce.mapper.CountryMapper;
import com.ajith.ecommerce.model.Country;
import com.ajith.ecommerce.repository.CountryRepository;
import com.ajith.ecommerce.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    @Override
    public String saveCounry(String country) {
     if (countryRepository.existsByNameIgnoreCase(country)){
         throw new ResourceAlreadyExistsException("country already exits");
        }
     countryRepository.save(Country.builder().name(country).build());
        return "country created";
    }

    @Override
    public List<CountryDto> getAllcountry() {
        return countryMapper.toDtoList( countryRepository.findAll());
    }

    @Override
    public String updateCountry(UUID id, String country) {
        Country country1 = countryRepository.findById(id).orElseThrow(()-> new  ResourceNotFoundException("country not found with this Id: %s".formatted(id),List.of("enter a valid id")));
        country1.setName(country);
        countryRepository.save(country1);
        return "country name have updated success fully";
    }

    @Override
    public String deleteCountryById(UUID id) {
        if (countryRepository.existsById(id)){
            countryRepository.deleteById(id);
            return "country with id %s have deleted successfully".formatted(id);
        }
        throw new ResourceNotFoundException("country Not found with Id: %s".formatted(id), List.of("enter a valid email address"));
    }
}
