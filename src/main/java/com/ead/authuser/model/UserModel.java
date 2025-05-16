package com.ead.authuser.model;

import com.ead.authuser.model.enums.UserStatus;
import com.ead.authuser.model.enums.UserType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "TB_USERS")
public class UserModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;
    @Column(nullable = false, unique = true, length = 50)
    private String username;
    @Column(nullable = false, unique = true, length = 50)
    private String email;
    @Column(nullable = false)
    @JsonIgnore
    private String password;
    @Column(nullable = false, length = 250)
    private String fullName;
    @Column(length = 20)
    private String phoneNumber;
    @Column(length = 20)
    private String cpf;
    @Column
    private String imageUrl;
    @Column(nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime creationDate;
    @Column(nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime lastUpdateDate;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserType userType;
}
