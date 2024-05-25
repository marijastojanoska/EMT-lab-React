package com.example.lab1b_emt.service;

import com.example.lab1b_emt.model.Accommodation;
import com.example.lab1b_emt.model.Category;
import com.example.lab1b_emt.model.Host;
import com.example.lab1b_emt.model.dto.AccommodationDto;

import java.util.List;
import java.util.Optional;

public interface AccommodationService {
    List<Accommodation> findAll();

    Optional<Accommodation> findById(Long id);
    Optional<Accommodation> reserve(Long id);

    Optional<Accommodation> add(String name, Category category, Long hostId, Integer numRooms);
    Optional<Accommodation> add(AccommodationDto accommodationDto);

    Optional<Accommodation> edit(Long id, String name, Category category, Long hostId, Integer numRooms);
    Optional<Accommodation> edit(Long id, AccommodationDto accommodationDto);

    void deleteById(Long id);
    void refreshMaterializedView();

}
