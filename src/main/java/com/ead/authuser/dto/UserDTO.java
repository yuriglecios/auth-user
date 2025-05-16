package com.ead.authuser.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
    private String username;
    private String email;
    private String password;
    private String fullName;
    private String phoneNumber;
    private String cpf;
    private String imageUrl;
}
