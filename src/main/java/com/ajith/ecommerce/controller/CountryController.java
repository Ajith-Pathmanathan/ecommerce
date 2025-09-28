package com.ajith.ecommerce.controller;

import com.ajith.ecommerce.dto.CountryDto;
import com.ajith.ecommerce.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/country")
@RequiredArgsConstructor
public class CountryController {
    private final CountryService countryService;
    @PostMapping
    public String saveCounry(String country){
       return countryService.saveCounry(country);
    }
    @GetMapping
    public List<CountryDto> getAllcountry(){
        return countryService.getAllcountry();
    }
    @PutMapping("/{id}")
    public String updateCountry(@PathVariable(value = "id")UUID id, @RequestBody String country){
        return countryService.updateCountry(id,country);
    }
    @DeleteMapping("/{id}")
    public String deleteCountryById(@PathVariable(value = "id") UUID id){
        return countryService.deleteCountryById(id);
    }
}
