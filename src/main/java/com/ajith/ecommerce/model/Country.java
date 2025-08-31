package com.ajith.ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Country {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String name;
    @OneToMany(mappedBy = "country")
    private List<City> cities;
    @OneToMany(mappedBy = "country" , fetch = FetchType.LAZY)
    private List<Users> users;
}

