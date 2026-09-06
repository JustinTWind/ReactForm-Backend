package com.react.form.controllers;

import com.react.form.dto.UserRequestDto;
import com.react.form.dto.UserResponseDto;
import com.react.form.models.Role;
import com.react.form.models.User;
import com.react.form.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    /** Minimal POST endpoint using DTOs */
    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto dto) {
        if (dto == null || dto.getUsername() == null || dto.getEmail() == null || dto.getHashedPassword() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        try {
            User user = new User();
            user.setUsername(dto.getUsername());
            user.setEmail(dto.getEmail());
            user.setHashedPassword(dto.getHashedPassword());
            user.setFullName(dto.getFullName());
            if (dto.getRole() != null) {
                try {
                    user.setRole(Role.valueOf(dto.getRole()));
                } catch (IllegalArgumentException iae) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
                }
            }
            user.setActive(dto.getActive() != null ? dto.getActive() : Boolean.TRUE);

            User created = userService.createUser(user);

            UserResponseDto resp = new UserResponseDto();
            resp.setId(created.getId());
            resp.setUsername(created.getUsername());
            resp.setEmail(created.getEmail());
            resp.setFullName(created.getFullName());
            resp.setRole(created.getRole() != null ? created.getRole().name() : null);
            resp.setActive(created.getActive());
            resp.setCreatedAt(created.getCreatedAt());

            return ResponseEntity.status(HttpStatus.CREATED).body(resp);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
