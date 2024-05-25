package com.example.lab1b_emt.service;

import com.example.lab1b_emt.model.Country;
import com.example.lab1b_emt.model.Host;
import com.example.lab1b_emt.model.dto.HostDto;

import java.util.List;
import java.util.Optional;

public interface HostService {
    List<Host> findAll();
    Optional<Host> findById(Long id);

    Optional<Host> add(String name, String surname, Long countryId);
    Optional<Host> add(HostDto hostDto);
    Optional<Host> edit(Long id, HostDto hostDto);
    Optional<Host> edit(Long id, String name, String surname, Long countryId);
    void deleteById(Long id);
}
