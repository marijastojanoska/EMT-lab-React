package com.example.lab1b_emt.repository;

import com.example.lab1b_emt.model.AccommodationPerCategoryView;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface AccommodationPerCategoryViewRepository extends JpaRepository<AccommodationPerCategoryView,Long> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = " MATERIALIZED VIEW public.accomodation_per_category", nativeQuery = true)
    void refreshMaterializedView();

}
