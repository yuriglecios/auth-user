package com.ead.authuser.controller;

import com.ead.authuser.model.UserModel;
import com.ead.authuser.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserModel>> getAllUsers() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.getAllUsers());
    }

    @GetMapping("{userId}")
    public ResponseEntity<UserModel> getOneUser(@PathVariable(value = "userId" ) UUID userId) {
        Optional<UserModel> user = userService.getOneUser(userId);
        return user.map(
                userModel -> ResponseEntity
                        .status(HttpStatus.OK)
                        .body(userModel))
                .orElseGet(() -> ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .build());
    }

    @DeleteMapping("{userId}")
    public ResponseEntity<Object> deleteOneUser(@PathVariable(value = "userId" ) UUID userId) {
        Optional<UserModel> user = userService.getOneUser(userId);
        return user.map(
                userModel -> {
                    userService.deleteUser(userModel);
                    return ResponseEntity
                            .status(HttpStatus.OK)
                            .build();
                })
                .orElseGet(() -> ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .build());
    }
}
