package com.example.lab1b_emt.repository;

import com.example.lab1b_emt.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
