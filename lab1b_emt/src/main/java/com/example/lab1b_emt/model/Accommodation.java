package com.example.lab1b_emt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Accommodation {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Category category;
    @ManyToOne
    private Host host;
    private Integer numRooms;

    public Accommodation(String name, Category category, Host host, Integer numRooms) {
        this.name = name;
        this.category = category;
        this.host = host;
        this.numRooms = numRooms;
    }
}
