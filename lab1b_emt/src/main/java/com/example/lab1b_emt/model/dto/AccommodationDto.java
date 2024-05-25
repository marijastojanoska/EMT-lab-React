package com.example.lab1b_emt.model.dto;

import com.example.lab1b_emt.model.Category;
import com.example.lab1b_emt.model.Host;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccommodationDto {
    private String name;
    private Category category;
    private Long hostId;
    private Integer numRooms;

    public AccommodationDto(String name, Category category, Long hostId, Integer numRooms) {
        this.name = name;
        this.category = category;
        this.hostId = hostId;
        this.numRooms = numRooms;
    }
}
