package com.example.lab1b_emt.service;

import com.example.lab1b_emt.model.Accommodation;
import com.example.lab1b_emt.model.Category;
import com.example.lab1b_emt.model.Country;
import com.example.lab1b_emt.model.Host;
import com.example.lab1b_emt.model.dto.CountryDto;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> findAll();

    Optional<Country> findById(Long id);

    Optional<Country> add(String name, String continent);
    Optional<Country> add(CountryDto countryDto);

    Optional<Country> edit(Long id, String name, String continent);
    Optional<Country> edit(Long id, CountryDto countryDto);

    void deleteById(Long id);

}
