package com.example.lab1b_emt.repository;

import com.example.lab1b_emt.model.Host;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HostRepository extends JpaRepository<Host, Long> {
}
