package com.example.lab1b_emt.config;

import com.example.lab1b_emt.model.Accommodation;
import com.example.lab1b_emt.model.Category;
import com.example.lab1b_emt.model.Country;
import com.example.lab1b_emt.model.Host;
import com.example.lab1b_emt.repository.AccommodationRepository;
import com.example.lab1b_emt.repository.CountryRepository;
import com.example.lab1b_emt.repository.HostRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataInitializer {
    private final AccommodationRepository accommodationRepository;
    private final CountryRepository countryRepository;
    private final HostRepository hostRepository;

    public List<Accommodation> accommodations;
    public List<Country> countries;
    public List<Host> hosts;

    public DataInitializer(AccommodationRepository accommodationRepository, CountryRepository countryRepository, HostRepository hostRepository) {
        this.accommodationRepository = accommodationRepository;
        this.countryRepository = countryRepository;
        this.hostRepository = hostRepository;
    }

    @PostConstruct
    public void init() {
        this.accommodations = new ArrayList<>();
        this.countries = new ArrayList<>();
        this.hosts = new ArrayList<>();

        if (countryRepository.count() == 0) {
            this.countries.add(new Country("Italy", "Europe"));
            this.countries.add(new Country("Germany", "Europe"));
            this.countries.add(new Country("China", "Asia"));

            this.countryRepository.saveAll(countries);
        }

        if (hostRepository.count() == 0) {
            this.hosts.add(new Host("Marija", "Stojanoska", this.countries.get(0)));
            this.hosts.add(new Host("Davor", "Georgijev", this.countries.get(1)));
            this.hosts.add(new Host("Petko", "Petkovski", this.countries.get(2)));

            hostRepository.saveAll(hosts);
        }

        if (accommodationRepository.count() == 0) {
            this.accommodations.add(new Accommodation("Hotel Test", Category.HOTEL, this.hosts.get(0), 100));
            this.accommodations.add(new Accommodation("Motel Test", Category.MOTEL, this.hosts.get(1), 50));
            this.accommodations.add(new Accommodation("Apartment Test", Category.APARTMENT, this.hosts.get(2), 10));

            accommodationRepository.saveAll(accommodations);
        }

    }
}
