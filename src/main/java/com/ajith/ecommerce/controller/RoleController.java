package com.ajith.ecommerce.controller;

import com.ajith.ecommerce.dto.RoleDto;
import com.ajith.ecommerce.service.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
@Tag(
        name = "CRUD REST API for role",
        description = "create , delete , update operation of role related details"
)
public class RoleController {
    private final RoleService roleService;

    @Operation(
            summary = "create role",
            description = "API for add new role")
    @ApiResponse(
            responseCode = "201",
            description = "HTTp status created")
    @PostMapping
    public String saveRoleService(@RequestBody RoleDto roleDto) {
        return roleService.saveRoleService(roleDto);
    }

    @Operation(
            summary = "update role",
            description = "API for update role")
    @ApiResponse(
            responseCode = "200",
            description = "HTTp status success")
    @PutMapping
    public String updateRole(@RequestBody RoleDto roleDto) {
        return roleService.updateRole(roleDto);
    }

    @Operation(
            summary = "delete role",
            description = "API for delete role")
    @ApiResponse(
            responseCode = "200",
            description = "HTTp status success")
    @DeleteMapping("/{id}")
    public String deleteRole(@PathVariable UUID id) {
        return roleService.deleteRole(id);
    }

    @Operation(
            summary = "get all roles",
            description = "API to get all roles"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTp status success",
            content = @Content(
                    array = @ArraySchema(
                            schema = @Schema(implementation = RoleDto.class)
                    )
            )
    )
    @GetMapping
    public List<RoleDto> getAllRoles() {
        return roleService.getAllRoles();
    }
}
