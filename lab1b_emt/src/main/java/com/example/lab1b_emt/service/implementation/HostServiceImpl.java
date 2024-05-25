package com.example.lab1b_emt.service.implementation;

import com.example.lab1b_emt.model.Country;
import com.example.lab1b_emt.model.Host;
import com.example.lab1b_emt.model.dto.HostDto;
import com.example.lab1b_emt.repository.HostRepository;
import com.example.lab1b_emt.service.CountryService;
import com.example.lab1b_emt.service.HostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HostServiceImpl implements HostService {

    private final HostRepository hostRepository;
    private final CountryService countryService;

    public HostServiceImpl(HostRepository hostRepository, CountryService countryService) {
        this.hostRepository = hostRepository;
        this.countryService = countryService;
    }

    @Override
    public List<Host> findAll() {
        return hostRepository.findAll();
    }

    @Override
    public Optional<Host> findById(Long id) {
        return hostRepository.findById(id);
    }

    @Override
    public Optional<Host> add(String name, String surname, Long countryId) {
        Country country = countryService.findById(countryId).get();
        Host host = new Host(name, surname, country);
        return Optional.of(hostRepository.save(host));
    }

    @Override
    public Optional<Host> add(HostDto hostDto) {
        Country country = countryService.findById(hostDto.getCountryId()).get();
        Host host = new Host(hostDto.getName(), hostDto.getSurname(), country);
        return Optional.of(hostRepository.save(host));
    }

    @Override
    public Optional<Host> edit(Long id, HostDto hostDto) {
        Country country = countryService.findById(hostDto.getCountryId()).get();
        Host host = this.findById(id).get();
        host.setCountry(country);
        host.setName(hostDto.getName());
        host.setSurname(hostDto.getSurname());
        return Optional.of(hostRepository.save(host));
    }

    @Override
    public Optional<Host> edit(Long id, String name, String surname, Long countryId) {
        Country country = countryService.findById(countryId).get();
        Host host = this.findById(id).get();
        host.setCountry(country);
        host.setName(name);
        host.setSurname(surname);
        return Optional.of(hostRepository.save(host));
    }

    @Override
    public void deleteById(Long id) {
        hostRepository.deleteById(id);
    }
}
