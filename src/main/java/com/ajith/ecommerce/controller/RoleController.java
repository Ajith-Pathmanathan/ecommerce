package com.ajith.ecommerce.controller;

import com.ajith.ecommerce.dto.RoleDto;
import com.ajith.ecommerce.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
public class RoleController {
    private final RoleService roleService;

    @PostMapping
    public String saveRoleService(@RequestBody RoleDto roleDto) {
        return roleService.saveRoleService(roleDto);
    }
    @PutMapping
    public String updateRole(@RequestBody RoleDto roleDto){
        return roleService.updateRole(roleDto);
    }
    @DeleteMapping("/{id}")
    public String deleteRole(@PathVariable UUID id){
        return roleService.deleteRole(id);
    }
    @GetMapping
    public List<RoleDto> getAllRoles(){
        return roleService.getAllRoles();
    }
}
