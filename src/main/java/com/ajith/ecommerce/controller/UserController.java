package com.ajith.ecommerce.controller;

import com.ajith.ecommerce.dto.UserRegisterDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Tag(
        name = "User Registration API",
        description = "API for user registration and related operations"
)
public class UserController {
    private final UserService userService;

    @PostMapping
    public Map<String, String> register(@RequestBody UserRegisterDto userRegisterDto) {
        return null;
    }
}
