package com.ajith.ecommerce.controller;

import com.ajith.ecommerce.dto.CityDto;
import com.ajith.ecommerce.dto.SaveCityDto;
import com.ajith.ecommerce.service.CityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/city")
@RequiredArgsConstructor
@Tag(
        name = "CRUD REST API for city",
        description = "create , delete , update operation of city related details"
)
public class CityController {

    private final CityService cityService;

    @Operation(
            summary = "create city",
            description = "API for add new city"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTp status created",
            content = @Content(
                    mediaType = "application/json"
            )
    )
    @PostMapping
    public String saveCity(@RequestBody SaveCityDto saveCityDto) {
        return cityService.saveCity(saveCityDto);

    }

    @Operation(
            summary = "get cities by country id",
            description = "API to get all cities by country id"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTp status success",
            content = @Content(
                    mediaType = "application/json",
                    array = @ArraySchema(
                            schema = @Schema(implementation = CityDto.class)
                    )
            )
    )
    @GetMapping("country/{id}")
    public List<CityDto> getCitiesByCountryId(@PathVariable(value = "id") UUID id) {
        return cityService.getCitiesByCountryId(id);
    }

    @Operation(
            summary = "update city",
            description = "API for update city name"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTp status success",
            content = @Content(
                    mediaType = "application/json"
            )
    )
    @PutMapping("/{id}")
    public String updateCity(@RequestBody String name, @PathVariable(value = "id") UUID id) {
        return cityService.updateCity(name, id);
    }

    @Operation(
            summary = "delete city",
            description = "API for delete city"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTp status success",
            content = @Content(
                    mediaType = "application/json"
            )
    )
    @DeleteMapping("/{id}")
    public String deleteCity(@PathVariable UUID id) {
        return cityService.deleteCity(id);
    }


}
