package com.example.lab1b_emt.service.implementation;

import com.example.lab1b_emt.model.Accommodation;
import com.example.lab1b_emt.model.Category;
import com.example.lab1b_emt.model.Host;
import com.example.lab1b_emt.model.dto.AccommodationDto;
import com.example.lab1b_emt.repository.AccommodationPerCategoryViewRepository;
import com.example.lab1b_emt.repository.AccommodationRepository;
import com.example.lab1b_emt.service.AccommodationService;
import com.example.lab1b_emt.service.HostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccommodationServiceImpl implements AccommodationService {
    private final AccommodationRepository accommodationRepository;
    private final AccommodationPerCategoryViewRepository accommodationPerCategoryViewRepository;
    private final HostService hostService;

    public AccommodationServiceImpl(AccommodationRepository accommodationRepository, AccommodationPerCategoryViewRepository accommodationPerCategoryViewRepository, HostService hostService) {
        this.accommodationRepository = accommodationRepository;
        this.accommodationPerCategoryViewRepository = accommodationPerCategoryViewRepository;
        this.hostService = hostService;
    }

    @Override
    public List<Accommodation> findAll() {
        return accommodationRepository.findAll();
    }

    @Override
    public Optional<Accommodation> findById(Long id) {
        return accommodationRepository.findById(id);
    }

    //TODO
    @Override
    public Optional<Accommodation> reserve(Long id) {
        Accommodation accommodation = this.findById(id).get();
        if (accommodation.getNumRooms() > 0) {
            accommodation.setNumRooms(accommodation.getNumRooms() - 1);
            return Optional.of(accommodationRepository.save(accommodation));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Accommodation> add(String name, Category category, Long hostId, Integer numRooms) {
        Host host = hostService.findById(hostId).get();
        Accommodation accommodation = new Accommodation(name, category, host, numRooms);
        return Optional.of(accommodationRepository.save(accommodation));
    }

    @Override
    public Optional<Accommodation> add(AccommodationDto accommodationDto) {
        Host host = hostService.findById(accommodationDto.getHostId()).get();
        Accommodation accommodation = new Accommodation(accommodationDto.getName(), accommodationDto.getCategory(), host, accommodationDto.getNumRooms());
        return Optional.of(accommodationRepository.save(accommodation));
    }

    @Override
    public Optional<Accommodation> edit(Long id, String name, Category category, Long hostId, Integer numRooms) {
        Host host = hostService.findById(hostId).get();
        Accommodation accommodation = this.findById(id).get();
        accommodation.setName(name);
        accommodation.setCategory(category);
        accommodation.setHost(host);
        accommodation.setNumRooms(numRooms);
        return Optional.of(accommodationRepository.save(accommodation));
    }

    @Override
    public Optional<Accommodation> edit(Long id, AccommodationDto accommodationDto) {
        Host host = hostService.findById(accommodationDto.getHostId()).get();
        Accommodation accommodation = this.findById(id).get();
        accommodation.setName(accommodationDto.getName());
        accommodation.setCategory(accommodationDto.getCategory());
        accommodation.setHost(host);
        accommodation.setNumRooms(accommodationDto.getNumRooms());
        return Optional.of(accommodationRepository.save(accommodation));
    }

    @Override
    public void deleteById(Long id) {
        accommodationRepository.deleteById(id);
    }

    @Override
    public void refreshMaterializedView() {
        //this.accommodationPerCategoryViewRepository.refreshMaterializedView();
    }
}
