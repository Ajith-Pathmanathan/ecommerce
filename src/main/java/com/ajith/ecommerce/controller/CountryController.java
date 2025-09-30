package com.ajith.ecommerce.controller;

import com.ajith.ecommerce.dto.CountryDto;
import com.ajith.ecommerce.service.CountryService;
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
@RequestMapping("/country")
@RequiredArgsConstructor
@Tag(
        name = "CRUD REST API for country",
        description = "create , delete , update operation of country related details"
)
public class CountryController {
    private final CountryService countryService;

    @Operation(
            summary = "create country",
            description = "API for add new country"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTp status created"
    )

    @PostMapping
    public String saveCounry(String country) {
        return countryService.saveCounry(country);
    }

    @Operation(
            summary = "get all country",
            description = "API to get all country"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTp status success",
            content = @Content(
                    array = @ArraySchema(
                            schema = @Schema(implementation = CountryDto.class)
                    )
            )
    )
    @GetMapping
    public List<CountryDto> getAllcountry() {
        return countryService.getAllcountry();
    }

    @Operation(
            summary = "update country",
            description = "API for update country")
    @ApiResponse(
            responseCode = "200",
            description = "HTTp status success")
    @PutMapping("/{id}")
    public String updateCountry(@PathVariable(value = "id") UUID id, @RequestBody String country) {
        return countryService.updateCountry(id, country);
    }

    @Operation(
            summary = "delete country",
            description = "API for delete country")
    @ApiResponse(
            responseCode = "200",
            description = "HTTp status success")
    @DeleteMapping("/{id}")
    public String deleteCountryById(@PathVariable(value = "id") UUID id) {
        return countryService.deleteCountryById(id);
    }
}
