package com.example.lab1b_emt.web;

import com.example.lab1b_emt.model.Accommodation;
import com.example.lab1b_emt.model.Category;
import com.example.lab1b_emt.model.dto.AccommodationDto;
import com.example.lab1b_emt.service.AccommodationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/accommodations")
public class AccommodationRestController {
    private final AccommodationService accommodationService;

    public AccommodationRestController(AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }

    @GetMapping
    private List<Accommodation> findAll() {
        return this.accommodationService.findAll();
    }

    @GetMapping("/categories")
    private List<Category> getAllCategories() {
        return Arrays.stream(Category.values()).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Accommodation> findById(@PathVariable Long id) {
        return this.accommodationService.findById(id)
                .map(accommodation -> ResponseEntity.ok().body(accommodation))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Accommodation> add(@RequestBody AccommodationDto accommodationDto) {
        return this.accommodationService.add(accommodationDto)
                .map(accommodation -> ResponseEntity.ok().body(accommodation))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Accommodation> edit(@PathVariable Long id, @RequestBody AccommodationDto accommodationDto) {
        return this.accommodationService.edit(id, accommodationDto)
                .map(accommodation -> ResponseEntity.ok().body(accommodation))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        this.accommodationService.deleteById(id);
        if (this.accommodationService.findById(id).isEmpty()) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/reserve/{id}")
    public ResponseEntity<Accommodation> reserve(@PathVariable Long id) {
        return this.accommodationService.reserve(id)
                .map(accommodation -> ResponseEntity.ok().body(accommodation))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

}
