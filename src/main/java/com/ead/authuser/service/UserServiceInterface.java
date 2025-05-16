package com.ead.authuser.service;

import com.ead.authuser.model.UserModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserServiceInterface {
    public List<UserModel> getAllUsers();
    public Optional<UserModel> getOneUser(UUID userId);

    public void deleteUser(UserModel userModel);

    void saveUser(UserModel userModel);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
