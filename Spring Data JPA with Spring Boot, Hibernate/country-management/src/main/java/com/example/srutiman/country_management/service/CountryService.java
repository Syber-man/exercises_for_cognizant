package com.example.srutiman.country_management.service;

import com.example.srutiman.country_management.entity.Country;
import com.example.srutiman.country_management.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    private final CountryRepository repository;

    public CountryService(CountryRepository repository) {
        this.repository = repository;
    }

    // Get all countries
    public List<Country> getAllCountries() {
        return repository.findAll();
    }

    // Find a country by code
    public Optional<Country> getCountryByCode(String code) {
        return repository.findById(code);
    }

    // Add a new country
    public Country addCountry(Country country) {
        return repository.save(country);
    }
}