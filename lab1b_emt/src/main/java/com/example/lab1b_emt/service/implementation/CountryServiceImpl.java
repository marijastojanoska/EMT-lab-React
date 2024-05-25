package com.example.lab1b_emt.service.implementation;

import com.example.lab1b_emt.model.Country;
import com.example.lab1b_emt.model.dto.CountryDto;
import com.example.lab1b_emt.repository.CountryRepository;
import com.example.lab1b_emt.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public Optional<Country> add(String name, String continent) {
        Country country = new Country(name,continent);
        return Optional.of(countryRepository.save(country));
    }

    @Override
    public Optional<Country> add(CountryDto countryDto) {
        Country country = new Country(countryDto.getName(),countryDto.getContinent());
        return Optional.of(countryRepository.save(country));
    }

    @Override
    public Optional<Country> edit(Long id, String name, String continent) {
        Country country = this.findById(id).get();
        country.setName(name);
        country.setContinent(continent);
        return Optional.of(countryRepository.save(country));
    }

    @Override
    public Optional<Country> edit(Long id, CountryDto countryDto) {
        Country country = this.findById(id).get();
        country.setName(countryDto.getName());
        country.setContinent(countryDto.getContinent());
        return Optional.of(countryRepository.save(country));
    }

    @Override
    public void deleteById(Long id) {
        countryRepository.deleteById(id);
    }
}
