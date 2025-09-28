package com.ajith.ecommerce.service.serviceImpl;

import com.ajith.ecommerce.dto.RoleDto;
import com.ajith.ecommerce.exception.ResourceNotFoundException;
import com.ajith.ecommerce.model.Role;
import com.ajith.ecommerce.repository.RoleRepository;
import com.ajith.ecommerce.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public String saveRoleService(RoleDto roleDto) {
        Role role = Role.builder()
                .name(roleDto.getName())
                .description(roleDto.getDescription())
                .build();
        roleRepository.save(role);
        return "role saved success fully";
    }

    @Override
    public String updateRole(RoleDto roleDto) {
        Role role = roleRepository.findById(roleDto.getId()).orElseThrow(() -> new ResourceNotFoundException("role not found id with :%s".formatted(roleDto.getId()), List.of("enter a valid role id")));
        role.setDescription(roleDto.getDescription());
        role.setName(roleDto.getName());
        roleRepository.save(role);
        return "role updated succesfull";
    }

    @Override
    public String deleteRole(UUID id) {
        if (roleRepository.existsById(id)) {
            roleRepository.deleteById(id);
            return "role deleted success fully";
        }
        throw new ResourceNotFoundException("role not found with id : %s".formatted(id), List.of("enter a valid role Id"));
    }

    @Override
    public List<RoleDto> getAllRoles() {
        List<Role> roles = roleRepository.findAll();

        return roles.stream().map(role ->
                RoleDto.builder()
                        .name(role.getName())
                        .id(role.getId())
                        .description(role.getDescription())
                        .build()
        ).toList();
    }
}
