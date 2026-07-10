package com.example.srutiman.country_management.controller;

import com.example.srutiman.country_management.entity.Country;
import com.example.srutiman.country_management.service.CountryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private final CountryService service;

    public CountryController(CountryService service) {
        this.service = service;
    }

    // Get all countries
    @GetMapping
    public List<Country> getAllCountries() {
        return service.getAllCountries();
    }

    // Get country by code
    @GetMapping("/{code}")
    public Optional<Country> getCountry(@PathVariable String code) {
        return service.getCountryByCode(code);
    }

    // Add a new country
    @PostMapping
    public Country addCountry(@RequestBody Country country) {
        return service.addCountry(country);
    }
}