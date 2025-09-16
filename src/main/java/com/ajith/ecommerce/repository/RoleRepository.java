package com.ajith.ecommerce.repository;

import com.ajith.ecommerce.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoleRepository  extends JpaRepository<Role, UUID> {
}
