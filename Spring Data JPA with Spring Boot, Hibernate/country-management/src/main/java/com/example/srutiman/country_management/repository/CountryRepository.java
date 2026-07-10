package com.example.srutiman.country_management.repository;

import com.example.srutiman.country_management.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, String> {

}