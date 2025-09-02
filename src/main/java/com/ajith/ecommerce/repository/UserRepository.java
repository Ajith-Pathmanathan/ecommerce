package com.ajith.ecommerce.repository;

import com.ajith.ecommerce.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<Users, UUID> {
}
