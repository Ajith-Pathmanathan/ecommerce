package com.ajith.ecommerce.repository;

import com.ajith.ecommerce.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CountryRepository extends JpaRepository<Country, UUID> {
    boolean existsByNameIgnoreCase(String country);
}
