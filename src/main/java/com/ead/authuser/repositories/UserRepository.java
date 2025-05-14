package com.ead.authuser.repositories;

import com.ead.authuser.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID> {
    List<UserModel> findAll();

    Optional<UserModel> findByUserId(UUID userId);

    UserModel deleteUser(UserModel userModel);
}
