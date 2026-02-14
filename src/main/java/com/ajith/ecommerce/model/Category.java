package com.ajith.ecommerce.model;

import com.ajith.ecommerce.model.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.UUID;

@Entity
@Table(name = "categories")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SQLDelete(sql = "UPDATE categories SET is_deleted = true WHERE id = ? and version = ?")
@SQLRestriction("is_deleted = false")
@Getter
@ToString(onlyExplicitlyIncluded = true)
public class Category extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @ToString.Include
    @Column(updatable = false, nullable = false)
    private UUID id;
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    @Column(name = "description", nullable = false)
    private String description;

    @Builder
    public Category(String name, String description) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("name cannot be null");
        if (description == null || description.isBlank()) throw new IllegalArgumentException("Description required");
        this.name = name;
        this.description = description;
    }

    public void updateDetails(String newName, String newDescription) {
        if (newName == null || newName.isBlank()) throw new IllegalArgumentException("name cannot be null");
        if (newDescription == null || newDescription.isBlank())
            throw new IllegalArgumentException("description cannot be null");
        this.name = newName;
        this.description = newDescription;
    }
}

