package com.example.lab1b_emt.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

@Data
@Entity
@Subselect("SELECT * FROM public.accommodation_per_category")
@Immutable
public class AccommodationPerCategoryView {

    @Id
    @Column(name = "accommodation_id")
    private Long accommodationId;

    @Column(name = "category")
    private Category category;
}
