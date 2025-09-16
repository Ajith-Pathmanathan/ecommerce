package com.ajith.ecommerce.controller;

import com.ajith.ecommerce.dto.CityDto;
import com.ajith.ecommerce.dto.SaveCityDto;
import com.ajith.ecommerce.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/city")
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;
    @PostMapping
    public String saveCity(@RequestBody SaveCityDto saveCityDto){
        return cityService.saveCity(saveCityDto);

    }
    @GetMapping("country/{id}")
    public List<CityDto> getCitiesByCountryId(@PathVariable(value = "id")UUID id){
        return cityService.getCitiesByCountryId(id);
    }
    @PutMapping("/{id}")
    public String updateCity(@RequestBody String name, @PathVariable(value = "id") UUID id){
        return cityService.updateCity(name,id);
    }
    @DeleteMapping("/{id}")
    public String deleteCity(@PathVariable UUID id){
        return cityService.deleteCity(id);
    }


}
