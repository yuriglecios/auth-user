package com.ead.authuser.model;

import com.ead.authuser.model.enums.UserStatus;
import com.ead.authuser.model.enums.UserType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_USERS")
public class UserModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private UUID userId;
    private String username;
    private String email;
    private String password;
    private String fullName;
    private String phoneNumber;
    private String cpf;
    private String imageUrl;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdateDate;
    private UserStatus userStatus;
    private UserType userType;
}
