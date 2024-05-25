package com.example.lab1b_emt.model.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CountryDto {
    private String name;
    private String continent;

    public CountryDto(String name, String continent) {
        this.name = name;
        this.continent = continent;
    }
}
