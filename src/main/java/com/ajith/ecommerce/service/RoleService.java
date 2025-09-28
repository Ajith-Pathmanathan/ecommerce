package com.ajith.ecommerce.service;

import com.ajith.ecommerce.dto.RoleDto;

import java.util.List;
import java.util.UUID;

public interface RoleService {
    String saveRoleService(RoleDto roleDto);

    String updateRole(RoleDto roleDto);

    String deleteRole(UUID id);

    List<RoleDto> getAllRoles();
}
