package com.ajith.ecommerce.model;

import com.ajith.ecommerce.model.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = "countries", indexes = {
        @Index(name = "idx_country_iso_code", columnList = "iso_code")
})
public class Country extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    @Column(name = "iso_code", nullable = false, unique = true)
    private String isoCode;

// reviewed
}

